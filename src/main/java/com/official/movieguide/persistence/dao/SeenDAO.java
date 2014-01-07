package com.official.movieguide.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.persistence.entity.Seen;
import com.official.movieguide.persistence.entity.User;

@Repository
public interface SeenDAO extends JpaRepository<Seen, Integer>
{
    public List<Seen> findByUser(User user);
    
    public List<Seen> findByMovie(Movie movie);
}
