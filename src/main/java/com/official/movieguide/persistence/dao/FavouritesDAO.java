package com.official.movieguide.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.official.movieguide.persistence.entity.Favourites;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.persistence.entity.User;

@Repository
public interface FavouritesDAO extends JpaRepository<Favourites, Integer>
{
    public List<Favourites> findByUser(User user);

    public List<Favourites> findByMovie(Movie movie);
}
