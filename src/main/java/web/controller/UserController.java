package web.controller;

import hiber.config.PersistenceJPAConfig;
import hiber.model.User;
import hiber.service.UserServise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller

public class UserController {
    private AnnotationConfigApplicationContext context;

    private UserServise userServise;

    public UserController() {
        context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        userServise = context.getBean(UserServise.class);
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userServise.getAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userServise.add(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServise.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userServise.getOne(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userServise.updateUser(user);
        return "redirect:/users";
    }
}
