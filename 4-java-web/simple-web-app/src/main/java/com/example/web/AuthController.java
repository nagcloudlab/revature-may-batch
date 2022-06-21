package com.example.web;


import com.example.entity.User;
import com.example.repository.JpaUserRepository;
import com.example.repository.UserRepository;
import com.example.service.AuthService;
import com.example.service.AuthServiceImpl;
import com.example.service.InvalidCredentialsException;
import com.example.service.UserNotFoundException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class AuthController extends HttpServlet {

    AuthService authService;

    public void init(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        UserRepository userRepository=new JpaUserRepository(emf);
        authService=new AuthServiceImpl(userRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // input
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // process
        try {
            User user = authService.authenticate(username, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("master");
            }
        }catch(UserNotFoundException | InvalidCredentialsException e){
            resp.sendRedirect("/simple-web-app");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();
        resp.sendRedirect("/simple-web-app");
    }

}
