package com.example.web;

import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/sign-up"
    )
    public ModelAndView addNewUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("username") String name
    ) {
        userService.register(username, password, name);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:sign-in.html");
        return mav;
    }

}
