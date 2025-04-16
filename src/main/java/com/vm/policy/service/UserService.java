package com.vm.policy.service;

import com.vm.policy.model.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}
