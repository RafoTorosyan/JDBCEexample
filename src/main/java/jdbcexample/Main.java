package jdbcexample;

import jdbcexample.manager.UserManager;
import jdbcexample.model.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();

        try {
            User user = new User("poxos","poxosyan","poxos@mail.com","poxos");
            userManager.addUser(user);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
