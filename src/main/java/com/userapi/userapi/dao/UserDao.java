package com.userapi.userapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapi.userapi.entities.User;
import com.userapi.userapi.service.UserRepository;

@Service
public class UserDao {

    @Autowired
    private UserRepository _userRepository;

    public List<User> getAllUsers(int n) {
        try {
            return _userRepository.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    public User getUserById(int id) {
        try {
            return _userRepository.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public User createUser(User user) {
        try {
            return _userRepository.save(user);
        } catch (Exception e) {
            return null;
        }
    }

    public User updateUser(int id, User user) {
        try {
            User _user = getUserById(id);
            if (_user != null) {
                _userRepository.save(user);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return user;
        }
    }
}
