package com.example.web;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.entity.User;
import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
public class TodosController {

    private TodoRepository todoRepository;
    private UserRepository userRepository;

    public TodosController(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/todos"
    )
    public ModelAndView getTodos(/*Principal principal*/) {
//        System.out.println(principal.getName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userdetails = (UserDetails) authentication.getPrincipal();
        String username = userdetails.getUsername();
        User dbUser = userRepository.findByUsername(username);
        Iterable<Todo> todos = todoRepository.findByUserId(dbUser.getId());
        ModelAndView mav = new ModelAndView(); // Map colln
        mav.addObject("all-todos", todos);
        mav.setViewName("todos-view");
        return mav;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/todos/delete-todo"
    )
    public ModelAndView deleteTodo(@RequestParam("id") int id) {
        todoRepository.deleteById(id);
        ModelAndView mav = new ModelAndView(); // Map colln
        mav.setViewName("redirect:todos");
        return mav;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/todos/new-todo"
    )
    public ModelAndView addTodo(
            @RequestParam("title") String title,
            @RequestParam("type") String type
    ) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setType(TodoType.valueOf(type));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userdetails = (UserDetails) authentication.getPrincipal();
        String username = userdetails.getUsername();
        User dbUser = userRepository.findByUsername(username);
        todo.setUser(dbUser);
        todoRepository.save(todo);
        ModelAndView mav = new ModelAndView(); // Map colln
        mav.setViewName("redirect:/todos");
        return mav;
    }


}
