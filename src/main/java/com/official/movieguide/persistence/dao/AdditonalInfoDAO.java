package com.official.movieguide.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.official.movieguide.persistence.entity.AdditionalInfo;

@Repository
public interface AdditonalInfoDAO extends JpaRepository<AdditionalInfo, Integer>
{
    public List<AdditionalInfo> findAll();

    public List<AdditionalInfo> findByMovieName(String movieName);

    @Query(value = "SELECT additionalInfo FROM AdditionalInfo additionalInfo WHERE additionalInfo.genre LIKE :genre")
    public List<AdditionalInfo> getByGenre(@Param("genre") String genre);

    @Query(value = "SELECT additionalInfo FROM AdditionalInfo additionalInfo WHERE additionalInfo.year >= :year")
    public List<AdditionalInfo> getByYear(@Param("year") int year);

    @Query(value = "SELECT additionalInfo FROM AdditionalInfo additionalInfo WHERE additionalInfo.imdbRating >= :rating")
    public List<AdditionalInfo> getByRating(@Param("rating") double rating);
}
