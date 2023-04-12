package web.pp_3_1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.pp_3_1_2.model.User;
import web.pp_3_1_2.service.UserService;


@Controller
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap modelUser) {
        modelUser.addAttribute("userList", userService.getUsers());
        return "users";
    }
    @GetMapping(value = "/addNewUser")
    public String addNewUser(ModelMap modelUser) {
        User addUser = new User();
        modelUser.addAttribute("userList", addUser);
        return "addUser";
    }
    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("userList") User userSave) {
        userService.saveUser(userSave);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}/deleteUser")
    public String deleteUser(@PathVariable("id") Long idDelete) {
        userService.deleteUser(idDelete);
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/editUser")
    public String editUser(Model modelUser, @PathVariable("id") Long idEdit) {
        modelUser.addAttribute("userList", userService.findUser(idEdit));
        return "editUser";
    }
    @PatchMapping(value = "/{id}/updateUser")
    public String updateUser(@ModelAttribute("userList") User userUpdate) {
        userService.updateUser(userUpdate);
        return "redirect:/";
    }
}
