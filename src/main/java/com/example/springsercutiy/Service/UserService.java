package com.example.springsercutiy.Service;

import com.example.springsercutiy.Entity.User;
import com.example.springsercutiy.Entity.Role;
public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String username,String rolename);
}
