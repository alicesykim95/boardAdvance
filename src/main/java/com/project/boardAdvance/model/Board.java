package com.project.boardAdvance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="board")
public class Board {

    @Id
    @GeneratedValue
    private int boardNum;

    @Column(name = "writer")
    private String writer;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "hitCnt")
    private int hitCnt;

    @CreatedDate
    @Column(updatable=false)
    private LocalDateTime createdDate = LocalDateTime.now();


}
