package com.project.boardAdvance.controller;

import com.project.boardAdvance.model.Board;
import com.project.boardAdvance.model.User;
import com.project.boardAdvance.service.BoardService;
import com.project.boardAdvance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    private final BoardService boardService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 메인 홈
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

    // 테스트
    @GetMapping("/boardPage")
    public String boardPage() { return "bBoard"; }

    // 게시글 등록
    @GetMapping("boardWrite")
    public String boardWrite() { return "bWrite"; }

    // 게시글 전체 목록
    @RequestMapping(value = "/boardList", method = RequestMethod.GET)
    public String boardAllList(Model model) {

        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("list", boardList);

        return "bList";
    }

    // 게시글 상세
    @RequestMapping(value = "/board/{boardNum}", method = RequestMethod.GET)
    public String getOneBoard(@PathVariable("boardNum") int boardNum, Model model) {
        model.addAttribute("board", boardService.getOneBoard(boardNum));
        return "bDetail";
    }


}
