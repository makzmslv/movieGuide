package com.official.movieguide.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.dao.AdditonalInfoDAO;
import com.official.movieguide.persistence.dao.MovieDAO;
import com.official.movieguide.persistence.entity.AdditionalInfo;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.persistence.entity.SearchMovieEntity;
import com.official.movieguide.service.AdditionalInformationService;
import com.official.movieguide.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService
{

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private AdditonalInfoDAO additonalInfoDAO;

    @Autowired
    private AdditionalInformationService additionalInformationService;

    public Movie getMovieByName(String movieName)
    {
        return movieDAO.findByName(movieName);
    }

    @Override
    public List<Movie> getMovies()
    {
        return movieDAO.findAll();
    }

    @Override
    public Movie addMovie(Movie movie)
    {
        return movieDAO.save(movie);
    }

    @Override
    public List<Movie> searchForMovie(SearchMovieEntity searchMovieEntity)
    {
        System.out.println(searchMovieEntity);
        List<Movie> movies = new ArrayList<Movie>();
        if (searchMovieEntity.getMovieName() != null)
        {
            String pattern = getPattern(searchMovieEntity.getMovieName());
            movies = movieDAO.getByNameLike(pattern);
            return movies;
        }

        if (searchMovieEntity.getRating() != null)
        {
            double rating = Double.parseDouble(searchMovieEntity.getRating());
            List<AdditionalInfo> additionalInfos = additonalInfoDAO.getByRating(rating);
            movies = movieDAO.getMoviesByAdditionalInfo(additionalInfos);
            return movies;
        }

        if (searchMovieEntity.getYear() != null)
        {
            List<AdditionalInfo> additionalInfos = additonalInfoDAO.getByYear(searchMovieEntity.getYear());
            movies = movieDAO.getMoviesByAdditionalInfo(additionalInfos);
            return movies;
        }

        if (searchMovieEntity.getGenre() != null)
        {
            String pattern = getPattern(searchMovieEntity.getGenre());
            List<AdditionalInfo> additionalInfos = additonalInfoDAO.getByGenre(pattern);
            movies = movieDAO.getMoviesByAdditionalInfo(additionalInfos);
            return movies;
        }
        return movies;
    }

    private String getPattern(String movieName)
    {
        return ("%" + movieName + "%");
    }

}
