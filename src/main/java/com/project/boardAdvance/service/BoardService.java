package com.project.boardAdvance.service;

import com.project.boardAdvance.model.Board;
import com.project.boardAdvance.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 등록
    public void saveBoard(Board board){
        boardRepository.save(board);
    }

    // 게시글 전체 조회
    public List<Board> getBoardList(){

        return boardRepository.findAllDesc();
    }

    // 게시글 상세 조회
    public Board getOneBoard(int boardNum){
        return boardRepository.findById(boardNum).get();
    }

    // 게시글 삭제
    public void deleteBoard(int boardNum){
        boardRepository.deleteById(boardNum);
    }

    // 조회수 증가
    public int updateHitCnt(int boardNum){
        return boardRepository.updateHitCnt(boardNum);
    }


}
