package com.example.web;

import com.example.repository.JdbcUserRepository;
import com.example.repository.UserRepository;
import com.example.service.AuthService;
import com.example.service.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

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
           HttpSession session=req.getSession();

           System.out.println(session.isNew());
           System.out.println(session.getId());
           System.out.println(new Date(session.getCreationTime()));
           System.out.println(new Date(session.getLastAccessedTime()));

           session.setAttribute("current-user",username);
           resp.sendRedirect("main.html");
       }

    }
}
