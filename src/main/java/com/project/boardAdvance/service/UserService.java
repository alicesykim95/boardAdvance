package com.project.boardAdvance.service;

import com.project.boardAdvance.model.User;
import com.project.boardAdvance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(User user) throws UsernameNotFoundException {
        user.setRole("USER");
        userRepository.save(user);
    }

//    public User loginUser(String userId, String userPw){
//
//        Optional<User> userWrapper = userRepository.findByUserIdAndUserPw(userId, userPw);
//
//}
}