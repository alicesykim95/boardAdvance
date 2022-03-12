package com.project.boardAdvance.repository;

import com.project.boardAdvance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // @Query("SELECT u FROM User u WHERE u.userId=:userId AND u.userPw=:userPw")
    // User loginUser(String userId, String userPw);
    // Collection<User> findByUser();
    // Optional<User> findByUserIdAndUserPw(String userId, String userPw);

}
