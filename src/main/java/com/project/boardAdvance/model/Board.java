package com.project.boardAdvance.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="board")
public class Board {

    @Id
    @GeneratedValue
    private int boardNum;

    @Column(length=100, nullable=false)
    private String writer;

    @Column(length=100, nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    @CreatedDate
    @Column(updatable=false)
    private LocalDateTime createdDate;


}
