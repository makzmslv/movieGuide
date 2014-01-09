package com.official.movieguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.dao.MovieDAO;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService
{

    @Autowired
    private MovieDAO movieDAO;

    public Movie getMovieByName(String movieName)
    {
        return movieDAO.findByName(movieName);
    }

    @Override
    public List<Movie> getMovies()
    {
        return movieDAO.findAll();
    }

}
