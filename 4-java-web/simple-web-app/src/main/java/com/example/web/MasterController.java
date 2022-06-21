package com.example.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/master"})
public class MasterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String currentUser = (String) session.getAttribute("user");
        if (currentUser == null) {
            resp.sendRedirect("/simple-web-app");
            return;
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/master-page.jsp");
        dispatcher.forward(req, resp);

    }
}
