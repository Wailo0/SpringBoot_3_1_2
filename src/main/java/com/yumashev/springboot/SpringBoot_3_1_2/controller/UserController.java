package com.yumashev.springboot.SpringBoot_3_1_2.controller;

import com.yumashev.springboot.SpringBoot_3_1_2.model.User;
import com.yumashev.springboot.SpringBoot_3_1_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user/show";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "show";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/user/show";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/user/show";
    }
}
