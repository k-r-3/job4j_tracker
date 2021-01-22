package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс предтавляет из себя модель данных, описывающую пользователя
 * @author Kozlov Roman
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Инициализирует экземляр класса
     * @param passport - Уникальный идентификатор пользователя
     * @param username - Имя пользователя. Не уникально
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Позволяет получить значение passport
     * @return - возвращает значение passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Позовляет задать значение passport
     * @param passport - Устанавливает значение passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Позволяет получить значение username
     * @return - Возвращает значение username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Позовляет задать значение username
     * @param username - Устанавливает значение username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Проверяет равенство текущего объекта и поля passport
     * между объектом {@param o} и полем o.passport
     * @param o - объект , с которым проверяется равенство
     * @return -  {@code true} в случе если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Создает хэш код объекта на основе поля passport
     * @return возвращает созданный хэш код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
