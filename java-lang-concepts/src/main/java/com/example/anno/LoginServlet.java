package com.example.anno;

/**
 * author : dev
 */

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet {

    public void doPost(){
        System.out.println("LoginServlet:doPost()");
    }

}
