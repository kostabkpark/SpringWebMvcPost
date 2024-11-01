package org.example.springweb.userdomain.controller;

import lombok.RequiredArgsConstructor;
import org.example.springweb.userdomain.domain.User;
import org.example.springweb.userdomain.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable("id") Integer id) {
//        return userService.getOneUser(id);
//    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userService.getOneUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.removeUser(userId);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable("userId") String userId,
                           @RequestBody User user) {
        user.setUserId(userId);
        userService.changePassword(user);
    }
}
