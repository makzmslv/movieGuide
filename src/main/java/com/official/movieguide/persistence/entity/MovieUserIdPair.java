package com.official.movieguide.persistence.entity;

public class MovieUserIdPair
{
    private Integer userId;

    private Integer movieId;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getMovieId()
    {
        return movieId;
    }

    public void setMovieId(Integer movieId)
    {
        this.movieId = movieId;
    }
}
