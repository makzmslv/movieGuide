package com.official.movieguide.persistence.entity;

public class SearchMovieEntity
{
    private String movieName;
    private String rating;
    private Integer year;
    private String genre;

    public String getMovieName()
    {
        return movieName;
    }

    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    @Override
    public String toString()
    {
        return "SearchMovieEntity [movieName=" + movieName + ", rating=" + rating + ", year=" + year + ", genre=" + genre + "]";
    }
}
