package com.official.movieguide.service;

import java.util.List;

import com.official.movieguide.persistence.entity.Movie;

public interface MovieService
{
    public Movie getMovieByName(String movieName);

    public List<Movie> getMovies();

    public List<Movie> addMovies(List<Movie> movies);

}

