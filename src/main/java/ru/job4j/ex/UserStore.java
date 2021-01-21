package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User sought = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                sought = user;
                break;
            }
        }
        if (sought == null) {
            throw new UserNotFoundException("User with this login not found");
        }
        return sought;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("This user login is invalid, or too short. "
                    + "It should be more 3 characters");
        }
        return true;
    }

    public static void main(String[] args) throws UserInvalidException, UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ie) {
            ie.printStackTrace();
        } catch (UserNotFoundException nfe) {
            nfe.printStackTrace();
        }
    }
}
