package org.example.springweb.userdomain.controller;


import jakarta.servlet.http.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springweb.userdomain.domain.User;
import org.example.springweb.userdomain.dto.UserLoginDto;
import org.example.springweb.userdomain.service.LoginService;
import org.example.springweb.userdomain.service.UserService;
import org.example.springweb.userdomain.session.SessionConst;
import org.example.springweb.userdomain.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto,
                        @RequestParam(required = true, defaultValue = "/posts") String redirectURI,
                        HttpServletRequest req,
                        HttpServletResponse res){
        User loginUser = loginService.login(userLoginDto);
        if(loginUser == null){
            return "redirect:/login";
        }
        // 로그인 성공 : 세션 생성
        UserSession userSession = new UserSession();
        userSession.setUserId(loginUser.getUserId());
        userSession.setUserName(loginUser.getUserName());

        HttpSession session = req.getSession(true);// 없으면 생성
        session.setAttribute(SessionConst.SESSION_NAME, userSession);

        // 로그인 성공한 세션 정보를 쿠키에 보내기
        Cookie cookie = new Cookie(SessionConst.COOKIE_NAME, SessionConst.SESSION_NAME);
        cookie.setPath("/");
        cookie.setMaxAge(600); // 600초 = 10분
        res.addCookie(cookie);

        return "redirect:" + redirectURI;        // login ==> /posts , parameter 로 redirectURI 가지고 온 경우에는
    }


}
