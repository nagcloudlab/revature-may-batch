package com.example.web;

import com.example.entity.Product;
import com.example.repository.JdbcProductRepository;
import com.example.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/products"})
public class ProductsController extends HttpServlet {

    ProductRepository productRepository = new JdbcProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productRepository.findAll();
        req.setAttribute("all-products",products);
        req.getRequestDispatcher("product-list.jsp").forward(req,resp);
    }
}
