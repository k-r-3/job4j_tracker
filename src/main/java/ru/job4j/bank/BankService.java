package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for(User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) throws BalanceException {
        boolean rsl = false;
        Account accountFrom = findByRequisite(srcPassport, srcRequisite);
        Account accountTo = findByRequisite(destPassport, destRequisite);
        if (accountFrom != null && accountTo != null) {
            double balance = accountFrom.getBalance() - amount;
            if (balance < 0.0) {
             throw new BalanceException("not enough money");
            }
                accountFrom.setBalance(balance);
                accountTo.setBalance(accountTo.getBalance() + amount);
                rsl = true;
            }
        return rsl;
    }
}
