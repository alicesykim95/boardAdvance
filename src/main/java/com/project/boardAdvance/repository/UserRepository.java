package com.project.boardAdvance.repository;

import com.project.boardAdvance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
