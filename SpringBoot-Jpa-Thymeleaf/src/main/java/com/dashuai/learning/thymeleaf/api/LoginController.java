package com.dashuai.learning.thymeleaf.api;

import com.dashuai.learning.thymeleaf.model.User;
import com.dashuai.learning.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User controller
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String list(Model model) {

        return "login/login";
    }

    @RequestMapping("/login/toAdd")
    public String toAdd() {
        return "login/userAdd";
    }

    @RequestMapping("/login/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

}