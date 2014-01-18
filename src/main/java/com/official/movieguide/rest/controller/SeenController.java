package com.official.movieguide.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.movieguide.persistence.entity.MovieUserIdPair;
import com.official.movieguide.persistence.entity.Seen;
import com.official.movieguide.service.SeenService;

@Controller
@RequestMapping("/seen")
public class SeenController
{
    @Autowired
    private SeenService seenService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Seen> getSeenByUser(@PathVariable("userId") Integer userId)
    {
        return seenService.getSeenByUser(userId);
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Seen> getSeenByMovie(@PathVariable("movieId") Integer movieId)
    {
        return seenService.getSeenByMovie(movieId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Seen addToSeen(@RequestBody MovieUserIdPair movieUserIdPair)
    {
        return seenService.addToSeen(movieUserIdPair.getUserId(), movieUserIdPair.getMovieId());
    }
}
