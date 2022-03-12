package com.project.boardAdvance.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false, unique = true)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPw;

    @Column(length = 100, nullable = false)
    private String userEmail;

    @CreationTimestamp
    private Timestamp createTime;

    @Enumerated(EnumType.STRING)
    private String role;



}
