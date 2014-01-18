package com.official.movieguide.service;

import java.util.List;

import com.official.movieguide.persistence.entity.Favourites;

public interface FavouritesService
{
    public Favourites addToFavourites(Integer movieID, Integer userID);

    public List<Favourites> getFavouritesByUser(Integer userID);

    public List<Favourites> getFavouritesByMovie(Integer movieID);
}
