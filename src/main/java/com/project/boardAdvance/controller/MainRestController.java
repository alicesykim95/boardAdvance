package com.project.boardAdvance.controller;

import com.project.boardAdvance.model.Board;
import com.project.boardAdvance.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainRestController {

    private final BoardService boardService;

    // 게시글 전체 리스트
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public List<Board> getListBoard() {
        return boardService.getBoardList();
    }

    // 게시글 등록
    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public void insertBoard(Board board){

        boardService.saveBoard(board);
    }

    // 게시글 상세 페이지
    @RequestMapping(value = "/board/{boardNum}", method = RequestMethod.GET)
    public Board getBoardDetail(@PathVariable("boardNum") int boardNum) throws Exception {
//        try{
//            System.out.println("a");
//        } catch(NullPointerException e) {
//            return null;
//        } catch(Exception e) {
//            System.out.println("b");
//        }
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
