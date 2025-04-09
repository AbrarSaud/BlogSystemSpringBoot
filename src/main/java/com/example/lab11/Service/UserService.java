package com.example.lab11.Service;

import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //     Get all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //     Add a new User
    public void addUser(User user) {
        userRepository.save(user);
    }

    //     Update a User
    public Boolean updateUser(Integer user_id, User user) {
        User oldUser = userRepository.findUserById(user_id);
        if (oldUser == null) {
            return false;
        }
        if (user.getUser_name() != null) {
            oldUser.setUser_name(user.getUser_name());
        }
        oldUser.setPassword(user.getPassword());
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        oldUser.setRegistration_date(user.getRegistration_date());

        userRepository.save(oldUser);
        return true;
    }

    //     Delete a User
    public Boolean deleteUser(Integer user_id) {
        User userToDelete = userRepository.findUserById(user_id);
        if (userToDelete == null) {
            return false;
        }
        userRepository.delete(userToDelete);
        return true;
    }

    // (Endpoint #8)
    public List<User> getUsersRegisteredBefore(String date) {
        return userRepository.getUsersRegisteredBefore(date);
    }


}
