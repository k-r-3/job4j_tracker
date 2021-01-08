package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        System.out.println();
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void viewItems(Input input, Tracker tracker) {
        System.out.println("All items :");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        String name = input.askStr("Insert new item name : ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Replacing an item\n");
        } else {
            System.out.println("ID not found, please try again\n");

        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        if (tracker.delete(id)) {
            System.out.println("item was removed\n");
        } else {
            System.out.println("ID not found, please try again\n");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("ID not found, please try again\n");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Insert item name : ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for(Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item not found, please try again\n");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select : "));
            System.out.println(select);
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.viewItems(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemByID(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                System.out.println("Exit...");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
}
