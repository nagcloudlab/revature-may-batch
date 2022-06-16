package com.example.repository;

import com.example.entity.User;

import java.sql.*;

public class JdbcUserRepository implements  UserRepository{
    @Override
    public User findByUserId(String username) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/demo";
            String dbUser="root";
            String dbPassword="root1234";
            Connection connection=DriverManager.getConnection(url,dbUser,dbPassword);
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
