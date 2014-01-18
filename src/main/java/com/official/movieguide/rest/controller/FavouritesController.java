package com.official.movieguide.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.movieguide.persistence.entity.Favourites;
import com.official.movieguide.persistence.entity.MovieUserIdPair;
import com.official.movieguide.service.FavouritesService;

@Controller
@RequestMapping("/favourites")
public class FavouritesController
{
    @Autowired
    private FavouritesService favouritesService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Favourites> getFavouritesByUser(@PathVariable("userId") Integer userId)
    {
        return favouritesService.getFavouritesByUser(userId);
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Favourites> getFavouritesByMovie(@PathVariable("movieId") Integer movieId)
    {
        return favouritesService.getFavouritesByMovie(movieId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Favourites addToFavourites(@RequestBody MovieUserIdPair movieUserIdPair)
    {
        return favouritesService.addToFavourites(movieUserIdPair.getMovieId(), movieUserIdPair.getUserId());
    }

}
