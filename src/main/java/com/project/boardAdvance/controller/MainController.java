package com.project.boardAdvance.controller;

import com.project.boardAdvance.model.User;
import com.project.boardAdvance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/home")
    public String homePage() {
        return "bHome";
    }

    // 회원가입
    @GetMapping("/joinPage")
    public String joinPage() {
        return "bJoin";
    }

    @PostMapping("/join")
    public String joinUser(User user) throws UsernameNotFoundException {
        String encPw = bCryptPasswordEncoder.encode(user.getUserPw());
        user.setUserPw(encPw);
        userService.joinUser(user);

        return "bJoin";
    }

    // 로그인
    @GetMapping("/loginPage")
    public String loginPage() {
        return "bLogin";
    }

//    @PostMapping(value="/login")
//    @ResponseBody
//    public int login(String userId, Model model) throws UsernameNotFoundException {
//
//
//}

}
