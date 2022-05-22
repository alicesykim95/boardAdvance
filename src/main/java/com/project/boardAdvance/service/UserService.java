package com.project.boardAdvance.service;

import com.project.boardAdvance.model.User;
import com.project.boardAdvance.model.UserRole;
import com.project.boardAdvance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public void joinUser(User user) throws UsernameNotFoundException {
        user.setRole(UserRole.valueOf("ROLE_USER"));
        userRepository.save(user);
    }

//    public User loginUser(String userId, String userPw){
//
//        Optional<User> userWrapper = userRepository.findByUserIdAndUserPw(userId, userPw);
//
//}
}