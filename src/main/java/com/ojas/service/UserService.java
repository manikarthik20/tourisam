package com.ojas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ojas.entity.User;
@Service
public interface UserService {
public User registerUser(User user);
public List<User> getAllUsers();

public Optional<User> getUserId(int id);
public void delete(int id);
public User update( User user);
public User saveOrUpdate(User user);

public User login(String username,String password);
}
