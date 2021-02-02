package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс предстваляет из себя програмный интерфейс приложения для обслуживания клиентов банка
 * на основе ассоциативного массива HashMap. Предоставляет функии добавления нового клиента,
 * добавления нового лицевого счета какому либо клиенту и перевод денежных средств между лицевыми
 * счетами клиента, или от одного клиента к другому
 * @author Kozlov Roman
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиента и его счета(ов) осуществляется в ассоциативной карте типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет в карту клиента и присваивает ему новый неинициализированный счет,
     * при условии, что этого клиента еще не существует в карте
     * @param user - Добавляемый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет клиенту, найденному по номеру паспорта новый инициалиированный лицевой счет.
     * Функция не выполнится, если клиент с указанным паспортом не найден, или
     * если у клиента уже имеется добавляемый счет
     * @param passport - Уникалный идентификатор клиента. Номер паспорта
     * @param account - Добавляемый лицевой счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Ищет пользователя среди добавленных
     * @param passport - Уникалный идентификатор клиента. Номер паспорта
     * @return - если среди добавленных клиентов есть паспорт с номером принимаемым на вход,
     * возвращает этого клиента. Если такой номер не найден среди ппаспортов клиентов, возвращает
     * значение null
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Stream.of(users.keySet())
                .flatMap(Set::stream)
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
        return rsl;
    }

    /**
     * Ищет лицевой счет среди добавленных клиентов
     * @param passport - Уникалный идентификатор клиента. Номер паспорта
     * @param requisite - Уникальный идентификатор счета
     * @return - если среди добавленных клиентов есть лицевой счет с номером принимаемым на вход,
     * возвращает этот счет. Если входящий номер паспрота не найден среди ппаспортов клиентов,
     * или входящий номер лицевого счета не найден, возвращает значение null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
            account = Stream.of(users.get(user.get()))
                .flatMap(List::stream)
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst();
        }
        return account;
    }

    /**
     * Осуществляет перевод денежных средств с одного лицевого счета на другой.
     * Лицевые счета могут принадлежать hкак одому клиенту, так и двум разным
     * @param srcPassport - Номер паспорта клиента, с чьего счета переводятся средства
     * @param srcRequisite - Номер лицевого счета, с которого переводятся средства
     * @param destPassport - Номер паспорта клиента, на чей счет переводятся средства
     * @param destRequisite - Номер лицевого счета, на который переводятся средства
     * @param amount - Сумма паеревода
     * @return - {@code true}, если найдены оба номера паспорта и оба номера лицевых счетов
     * среди добаленных пользователей, а на счете, с которого осуществляется перевод,
     * средств не меньше чем сумма перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Optional<Account> accountFrom = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountTo = findByRequisite(destPassport, destRequisite);
        boolean isPresent = (accountFrom.isPresent() && accountTo.isPresent());
        if (isPresent) {
            if (accountFrom.get().getBalance() >= amount) {
                accountFrom.get().setBalance(accountFrom.get().getBalance() - amount);
                accountTo.get().setBalance(accountTo.get().getBalance() + amount);
                return true;
            }
        }
        return isPresent;
    }
}