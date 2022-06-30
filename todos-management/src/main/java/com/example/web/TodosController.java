package com.example.web;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodosController {

    private TodoRepository todoRepository;

    public TodosController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/todos"
    )
    public ModelAndView getTodos() {
        Iterable<Todo> todos = todoRepository.findAll();
        ModelAndView mav = new ModelAndView(); // Map colln
        mav.addObject("all-todos", todos);
        mav.setViewName("todos-view");
        return mav;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/delete-todo"
    )
    public ModelAndView deleteTodo(@RequestParam("id") int id) {
       todoRepository.deleteById(id);
        ModelAndView mav = new ModelAndView(); // Map colln
        mav.setViewName("redirect:todos");
        return mav;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/new-todo"
    )
    public ModelAndView addTodo(
            @RequestParam("title") String title,
            @RequestParam("type") String type
    ) {
        Todo todo=new Todo();
        todo.setTitle(title);
        todo.setType(TodoType.valueOf(type));
        todoRepository.save(todo);
        ModelAndView mav = new ModelAndView(); // Map colln
        mav.setViewName("redirect:todos");
        return mav;
    }


}
