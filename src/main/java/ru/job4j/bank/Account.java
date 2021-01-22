package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет из себя модель данных, описывающую банковский счет
 * @author Kozlov Roman
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Инициалиирует экземпляр класса
     * @param requisite - уникальный идентификатор счета
     * @param balance - сумма средств, доступных по текущему счету
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Позволяет получть значение requisite
     * @return - Возвращает значение requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Позволяет устанавить значение requisite
     * @param requisite - Устанавливает значение requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Позволяет получить значение balance
     * @return - Возвращает значение balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Позволяет устанавить значение balance
     * @param balance - Устанавливает значение balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Проверяет равенство текущего объекта и поля requisite
     * между объектом o и полем o.requisite
     * @param o - объект , с которым проверяется равенство
     * @return - {@code true} если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Создает хэш код объекта на основе поля requisite
     * @return возвращает созданный хэш код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
