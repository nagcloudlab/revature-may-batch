package com.example.web;

import com.example.entity.Product;
import com.example.repository.JdbcProductRepository;
import com.example.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/products", "/delete-product"})
public class ProductsController extends HttpServlet {

    ProductRepository productRepository = new JdbcProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));

        String currentUser = (String) session.getAttribute("current-user");
        System.out.println(currentUser);
        if(currentUser != null) {
            String reURI = req.getRequestURI();
            // read
            if (reURI.equals("/pm/products")) {
                List<Product> products = productRepository.findAll();
                req.setAttribute("all-products", products);
                req.getRequestDispatcher("product-list.jsp").forward(req, resp);
            }
            if (reURI.equals("/pm/delete-product")) {
                String id = req.getParameter("id");
                productRepository.delete(Integer.parseInt(id));
                resp.sendRedirect("products");
            }
        }else{
            resp.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        Product product = new Product();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        productRepository.save(product);
        resp.sendRedirect("products");

    }
}
