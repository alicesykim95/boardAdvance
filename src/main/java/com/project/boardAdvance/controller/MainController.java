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
        String encPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encPw);
        userService.joinUser(user);

        return "redirect:/home";
    }

    // 로그인
    @GetMapping("/loginPage")
    public String loginPage() {
        return "bLogin";
    }

    // Test
    @GetMapping("/boardPage")
    public String boardPage() { return "bBoard"; }

    // 게시글 등록
    @GetMapping("boardWrite")
    public String boardWrite() { return "bWrite"; }

    // 게시글 목록
    @GetMapping("boardList")
    public String boardList() { return "bList"; }

}
