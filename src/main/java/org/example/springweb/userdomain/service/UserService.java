package org.example.springweb.userdomain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springweb.userdomain.domain.User;
import org.example.springweb.userdomain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getOneUser(String userId) {
        User user = userRepository.findByUserId(userId);
        return user;
    }

    public void removeUser(String userId) {
//        User user = userRepository.findByUserId(userId);
//        if(user != null) {
//            userRepository.delete(user);
//        }
        userRepository.deleteByUserId(userId);
    }

    public void changePassword(User user) {
        User oldUser = getOneUser(user.getUserId());
        if(oldUser != null
                && !oldUser.getPassword().equals(user.getPassword())
                && !user.getPassword().equals(""))
         {
            log.info("Changing password for user = <{}>" , user.getPassword());
            oldUser.setPassword(user.getPassword());
            userRepository.save(oldUser);
        }
    }
}
