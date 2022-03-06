package com.project.boardAdvance.controller;

import com.project.boardAdvance.model.User;
import com.project.boardAdvance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "bJoin";
    }

    @PostMapping("/join")
    public String joinPage(User user) {
        String encPw = bCryptPasswordEncoder.encode(user.getUserPw());
        user.setUserPw(encPw);
        userRepository.save(user);

        return "bJoin";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "bLogin";
    }

}
