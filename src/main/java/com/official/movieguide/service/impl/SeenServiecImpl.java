package com.official.movieguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.dao.MovieDAO;
import com.official.movieguide.persistence.dao.SeenDAO;
import com.official.movieguide.persistence.dao.UserDAO;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.persistence.entity.Seen;
import com.official.movieguide.persistence.entity.User;
import com.official.movieguide.service.SeenService;

@Service
public class SeenServiecImpl implements SeenService
{
    @Autowired
    private SeenDAO seenDAO;

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Seen addToSeen(Integer userId, Integer movieId)
    {
        User user = userDAO.findOne(userId);
        Movie movie = movieDAO.findOne(movieId);
        Seen seen = createSeenEntity(user, movie);

        return seenDAO.save(seen);
    }

    private Seen createSeenEntity(User user, Movie movie)
    {
        Seen seen = new Seen();
        seen.setMovie(movie);
        seen.setUser(user);

        return seen;
    }

    @Override
    public List<Seen> getSeenByUser(Integer userId)
    {
        User user = userDAO.findOne(userId);
        return seenDAO.findByUser(user);
    }

    @Override
    public List<Seen> getSeenByMovie(Integer movieId)
    {
        Movie movie = movieDAO.findOne(movieId);
        return seenDAO.findByMovie(movie);
    }

}
