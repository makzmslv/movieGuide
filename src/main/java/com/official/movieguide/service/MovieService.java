package com.official.movieguide.service;

import java.util.List;

import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.persistence.entity.SearchMovieEntity;

public interface MovieService
{
    public Movie getMovieByName(String movieName);

    public List<Movie> getMovies();

    public Movie addMovie(Movie movies);

    public List<Movie> searchForMovie(SearchMovieEntity searchMovieEntity);

}

