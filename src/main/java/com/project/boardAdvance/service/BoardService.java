package com.project.boardAdvance.service;

import com.project.boardAdvance.model.Board;
import com.project.boardAdvance.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 등록
    public Board insertBoard(Board board){
        return boardRepository.save(board);
    }


}
