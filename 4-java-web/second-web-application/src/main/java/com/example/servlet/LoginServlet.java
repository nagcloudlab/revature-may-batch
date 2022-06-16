package com.example.servlet;

import com.example.repository.JdbcUserRepository;
import com.example.repository.UserRepository;
import com.example.service.AuthService;
import com.example.service.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    UserRepository userRepository=new JdbcUserRepository();
    AuthService authService=new AuthServiceImpl(userRepository);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");

       boolean b=authService.authenticate(username,password);

       if(!b){
           resp.sendRedirect("login.html");
       }else{
           resp.sendRedirect("main.html");
       }

    }
}
