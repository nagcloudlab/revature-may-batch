package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductRepository implements ProductRepository {

    public void save(Product product) {

        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "insert into products(name,price) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "select * from products";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public Product findById(int id) {
        return null;
    }

    public void delete(int id) {

        try (Connection connection = SQLConnectionFactory.getConnection()) {
            String sql = "delete from products where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
