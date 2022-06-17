package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.Product;
import com.example.entity.User;

import java.sql.*;

public class JdbcUserRepository implements  UserRepository{
    @Override
    public User findByUserId(String username) {

        try (Connection connection= SQLConnectionFactory.getConnection()){
            String sql="select * from users where username=?";
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void save(User user) {

        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "insert into users(username,password) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
