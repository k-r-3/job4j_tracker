package ru.job4j.ex;

import java.util.Arrays;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException(key + " not foound in " + Arrays.toString(value));
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] values = {"One", "Two", "Three"};
        try {
            indexOf(values, "Four");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
