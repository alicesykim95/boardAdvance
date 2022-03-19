package com.project.boardAdvance.repository;

import com.project.boardAdvance.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 게시글 전체 조회
    @Query("SELECT b FROM Board b ORDER BY b.boardNum DESC")
    List<Board> findAllDesc();

    // 게시글 상세 조회
    @Query("SELECT b FROM Board b WHERE b.boardNum =:boardNum")
    Optional<Board> findById(Integer boardNum);

    // 게시글 삭제
//    @Query("DELETE FROM Board WHERE boardNum =:boardNum")
//    void deleteById(Integer boardNum);


}
