package com.example.anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author : Nag
 */

public class Tomcat {


    public void processRequest(String url, String httpMethod) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {

        // by classpath-scanning
        Class<?> clazz = Class.forName("com.example.anno.LoginServlet");
        WebServlet webServlet = clazz.getAnnotation(WebServlet.class);
        if (webServlet != null) {
            String mappedUrl = webServlet.urlPatterns()[0];
            Object instance = clazz.newInstance();
            if (mappedUrl.equals(url) && httpMethod.equals("POST")) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getName().equals("doPost")) {
                        method.invoke(instance);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Tomcat tomcat = new Tomcat();

        String url = "/den-login";
        String httpMethod = "POST";
        tomcat.processRequest(url, httpMethod);

    }

}
