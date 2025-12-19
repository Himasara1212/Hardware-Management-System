package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    Connection connection ;
    public boolean isEmailExist(String email) throws SQLException {
        connection = DBConnection.getInstance().getConnection();

        String sql = "select * from user where email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();

    }

    public UserDto getUser(String email) throws SQLException {
        connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        UserDto userDto = null;

        if (resultSet.next()) {
            userDto = new UserDto();

            userDto.setUserId(resultSet.getString("user_id"));
            userDto.setUsername(resultSet.getString("user" +
                    "name"));
            userDto.setEmail(resultSet.getString("email"));
            userDto.setPassword(resultSet.getString("password"));

        }

        return userDto;
    }

}
