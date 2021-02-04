package ru.job4j.stream.builtobject;

public class Pojo {
    private String name;
    private String surname;
    private short age;
    private boolean isMarried;
    private short salary;
    private String position;

    static class Builder {
        private String name;
        private String surname;
        private short age;
        private boolean isMarried;
        private short salary;
        private String position;

        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder buildAge(short age) {
            this.age = age;
            return this;
        }

        public Builder buildMarried(boolean married) {
            isMarried = married;
            return this;
        }

        public Builder buildSalary(short salary) {
            this.salary = salary;
            return this;

        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

         Pojo build() {
            Pojo pojo = new Pojo();
            pojo.name = name;
            pojo.surname = surname;
            pojo.age = age;
            pojo.isMarried = isMarried;
            pojo.salary = salary;
            pojo.position = position;
            return pojo;
        }
    }

    @Override
    public String toString() {
        return "Pojo{" + "name='"
                + name + '\'' + ", surname='"
                + surname + '\'' + ", age=" + age
                + ", isMarried=" + isMarried
                + ", salary=" + salary
                + ", position='" + position + '\''
                + '}';
    }
}
