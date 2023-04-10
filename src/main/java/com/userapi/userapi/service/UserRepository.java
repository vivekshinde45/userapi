package com.userapi.userapi.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.userapi.userapi.entities.User;

@Service
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findById(int id);

    public List<User> findAll();
}
