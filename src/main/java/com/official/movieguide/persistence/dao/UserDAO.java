package com.official.movieguide.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.official.movieguide.persistence.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>
{
    public User findByUsername(String username);
}
