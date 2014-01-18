package com.official.movieguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.dao.FavouritesDAO;
import com.official.movieguide.persistence.dao.MovieDAO;
import com.official.movieguide.persistence.dao.UserDAO;
import com.official.movieguide.persistence.entity.Favourites;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.persistence.entity.User;
import com.official.movieguide.service.FavouritesService;

@Service
public class FavouritesServiceImpl implements FavouritesService
{

    @Autowired
    private FavouritesDAO favouritesDAO;

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Favourites addToFavourites(Integer movieID, Integer userID)
    {
        User user = userDAO.findOne(userID);
        Movie movie = movieDAO.findOne(movieID);
        Favourites favourites = createFavouriteEntity(movie, user);
        return favouritesDAO.save(favourites);
    }

    private Favourites createFavouriteEntity(Movie movie, User user)
    {
        Favourites favourites = new Favourites();
        favourites.setUser(user);
        favourites.setMovie(movie);
        return favourites;
    }

    @Override
    public List<Favourites> getFavouritesByUser(Integer userID)
    {
        User user = userDAO.findOne(userID);
        return favouritesDAO.findByUser(user);
    }

    @Override
    public List<Favourites> getFavouritesByMovie(Integer movieID)
    {
        Movie movie = movieDAO.findOne(movieID);
        return favouritesDAO.findByMovie(movie);
    }

}
