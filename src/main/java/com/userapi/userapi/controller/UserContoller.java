package com.userapi.userapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userapi.userapi.dao.UserDao;
import com.userapi.userapi.entities.User;

@RestController
public class UserContoller {
    @Autowired
    private UserDao _userDao;

    @GetMapping("/get_users/{n}/{user}")
    public ResponseEntity<List<User>> getUsers(@PathVariable("n") int n, @PathVariable("user") String user) {
        try {
            // if (user.toLowerCase() == "reader") {
            List<User> _users = _userDao.getAllUsers(n);
            if (_users.size() >= 0) {
                return ResponseEntity.ok(_users);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            // }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create_data")
    public ResponseEntity<User> createData(@RequestBody User user) {
        try {
            // if (user.getUser().toLowerCase() == "admin") {
            User _user = _userDao.createUser(user);
            if (_user != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(user);
            }
            // }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
        }
    }

    @PutMapping("/update_data/{userid}")
    public ResponseEntity<User> updateData(@RequestBody User user, @PathVariable("userid") int userid) {
        try {
            User _user = _userDao.updateUser(userid, user);
            if (_user != null) {
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
