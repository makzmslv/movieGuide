package com.official.movieguide.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.official.movieguide.persistence.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
    public User findByUsername(String username);
}
