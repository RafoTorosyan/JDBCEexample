package jdbcexample.manager;

import jdbcexample.db.DBConnectionProvider;
import jdbcexample.model.User;

import java.sql.*;


public class UserManager {

    private Connection connection;

    public UserManager() {

        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addUser(User user) throws SQLException {

        PreparedStatement preparedstatement = connection.prepareStatement("insert into user(name, surname, email, password) Values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedstatement.setString(1, user.getName());
        preparedstatement.setString(2, user.getSurname());
        preparedstatement.setString(3, user.getEmail());
        preparedstatement.setString(4, user.getPassword());
        preparedstatement.executeUpdate();

        ResultSet resultSet = preparedstatement.getGeneratedKeys();
         if (resultSet.next()){
             int id = resultSet.getInt(1);

             user.setId(id);
         }
    }

}
