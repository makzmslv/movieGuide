package com.official.movieguide.service;

import com.official.movieguide.persistence.entity.Movie;

public interface MovieService
{
    public Movie getMovieByName(String movieName);
}

