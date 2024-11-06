package org.example.springweb.userdomain.service;

import lombok.RequiredArgsConstructor;
import org.example.springweb.userdomain.domain.User;
import org.example.springweb.userdomain.dto.UserLoginDto;
import org.example.springweb.userdomain.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public User login(UserLoginDto userDto) {
        User user = userRepository.findByUserId(userDto.getUserId());
        if (user != null && user.getPassword().equals(userDto.getPassword())) {
            return user;
        }
        return null;
    }
}
