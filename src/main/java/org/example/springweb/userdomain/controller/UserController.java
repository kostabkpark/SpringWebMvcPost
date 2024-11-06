package org.example.springweb.userdomain.controller;

import lombok.RequiredArgsConstructor;
import org.example.springweb.userdomain.domain.User;
import org.example.springweb.userdomain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        // 세션 정보를 얻어온다. => 로그인 된 상태인지 확인  ==> 사용자가 admin 일 때만
        return userService.getAllUsers();
    }


    @GetMapping("/register")
    public String createUser() {
        return "user/userRegister";
    }
    @PostMapping("/register")
    public String createUser(@RequestBody User user) {
        userService.createNewUser(user);
        return "redirect:/login";
    }

    // 본인의 정보만 수정할 수 있는 기능 추가 필요

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        // 세션 정보를 얻어온다. => 로그인 된 상태인지 확인  ==> 본인이 맞는지 확인해서 본인의 정보만 조회해야 한다.
        return userService.getOneUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        // 세션 정보를 얻어온다. => 로그인 된 상태인지 확인  ==> 본인이 맞는지 확인해서 본인인 경우에만 탈퇴해야 한다.
        userService.removeUser(userId);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable("userId") String userId,
                           @RequestBody User user) {
        // 세션 정보를 얻어온다. => 로그인 된 상태인지 확인  ==> 본인이 맞는지 확인해서 본인인 경우에만 수정해야 한다.
        user.setUserId(userId);
        userService.changePassword(user);
    }
}
