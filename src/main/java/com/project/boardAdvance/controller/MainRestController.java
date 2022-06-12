package com.project.boardAdvance.controller;

import com.project.boardAdvance.model.Board;
import com.project.boardAdvance.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainRestController {

    private final BoardService boardService;

    // 게시글 전체 리스트
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ResponseEntity<List<Board>> getListBoard() {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardList());
    }

    // 게시글 등록
    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public void insertBoard(Board board){
        boardService.saveBoard(board);
    }

    // 게시글 상세 페이지
    @RequestMapping(value = "/board/{boardNum}", method = RequestMethod.GET)
    public Board getBoardDetail(@PathVariable("boardNum") int boardNum) throws Exception {
        return boardService.getOneBoard(boardNum);
    }

    // 게시글 수정
    @RequestMapping(value = "/board", method = RequestMethod.PUT)
    public void updateBoard(Board board){
        boardService.updateBoard(board);
    }

    // 게시글 삭제
    @RequestMapping(value = "/board", method = RequestMethod.DELETE)
    public String deleteBoard(int boardNum){
        boardService.deleteBoard(boardNum);
        return "redirect:/";
    }

}
