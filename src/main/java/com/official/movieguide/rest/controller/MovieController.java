package com.official.movieguide.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.MovieService;

@Controller
@RequestMapping(value = "/movies")
public class MovieController
{
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/{movieName}", method = RequestMethod.GET)
    @ResponseBody
    public Movie getMovieById(@PathVariable("movieName") String movieName)
    {
        return movieService.getMovieByName(movieName);
    }
}
