package com.official.movieguide.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.dao.UserDAO;
import com.official.movieguide.persistence.entity.User;
import com.official.movieguide.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO userDAO;

    private static final int ROLE_USER = 2;
    @Override
    public User addUser(User user)
    {
        String encodedPassword = encodeUserPassword(user);
        user.setPassword(encodedPassword);
        user.setRole(ROLE_USER);;
        return userDAO.save(user);
    }

    private String encodeUserPassword(User user)
    {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        return encoder.encodePassword(user.getPassword(), user.getUsername());
    }

}
