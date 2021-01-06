package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public void add(Item item) {
        item.setId(ids++);
        items[size++] = item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] notNullItems = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                notNullItems[count++] = items[i];
            }
        }
       return Arrays.copyOf(notNullItems, count);
    }

    public Item[] findByName(String key) {
        Item[] findNames = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                findNames[count++] = items[i];
            }
        }
        return Arrays.copyOf(findNames, count);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items[index] = new Item(id, item.getName());
        return true;
    }

    public boolean delete (int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        int start = index + 1;
        int length = size - index;
        System.arraycopy(items, start, items, index, length);
        items[size - 1] = null;
        size--;
        return true;
    }
}