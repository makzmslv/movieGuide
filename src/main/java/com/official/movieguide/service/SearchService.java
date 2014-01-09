package com.official.movieguide.service;

import java.util.List;

import com.official.movieguide.persistence.entity.Movie;

public interface SearchService
{
    public List<Movie> search(String directoryPath);
}
