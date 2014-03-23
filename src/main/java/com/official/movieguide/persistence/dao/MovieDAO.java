package com.official.movieguide.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.official.movieguide.persistence.entity.AdditionalInfo;
import com.official.movieguide.persistence.entity.Movie;

@Repository
public interface MovieDAO extends JpaRepository<Movie, Integer>
{
    public Movie findByName(String movieName);

    @Query(value = "SELECT movies FROM Movie movies WHERE movies.name LIKE :movieName")
    public List<Movie> getByNameLike(@Param("movieName") String movieName);

    @Query(value = "SELECT movies FROM Movie movies WHERE movies.additional_Info IN :additionalInfos")
    public List<Movie> getMoviesByAdditionalInfo(@Param("additionalInfos") List<AdditionalInfo> additionalInfos);
}
