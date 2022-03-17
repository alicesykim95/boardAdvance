package com.project.boardAdvance.controller;

import com.project.boardAdvance.model.Board;
import com.project.boardAdvance.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainRestController {

    private final BoardService boardService;

    @PostMapping("/board")
    public Board insertBoard(Board board){
        return boardService.insertBoard(board);
    }

}
