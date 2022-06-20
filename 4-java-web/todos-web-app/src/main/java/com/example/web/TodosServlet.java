package com.example.web;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.repository.JpaTodoRepository;
import com.example.repository.TodoRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/todos","/delete-todo"})
public class TodosServlet extends HttpServlet {

    private TodoRepository todoRepository;

    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        todoRepository = new JpaTodoRepository(emf);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();
        String httpMethod = req.getMethod();
        if (httpMethod.equals("GET") && reqPath.equals("/todos-web/todos")) {
            // Get todos from database
            List<Todo> todos = todoRepository.findAll();
            System.out.println(todos.size());
            req.setAttribute("todos", todos);
            req.getRequestDispatcher("/WEB-INF/todos-view.jsp").forward(req, resp);
        }
        if (httpMethod.equals("POST") && reqPath.equals("/todos-web/todos")) {
            String title = req.getParameter("title");
            Todo todo = new Todo();
            todo.setTitle(title);
            todo.setType(TodoType.HOME);
            // Get todos from database
            todoRepository.save(todo);
            resp.sendRedirect("todos");
        }
        if (httpMethod.equals("GET") && reqPath.equals("/todos-web/delete-todo")) {
            String id = req.getParameter("id");
            todoRepository.delete(Integer.parseInt(id));
            resp.sendRedirect("todos");
        }
    }
}
