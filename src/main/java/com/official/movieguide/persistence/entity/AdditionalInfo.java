package com.official.movieguide.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Additional_Info")
public class AdditionalInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "director")
    private String director;

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "imdbRating")
    private double imdbRating;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "plot")
    private String plot;

    @Column(name = "poster")
    private String poster;

    @Column(name = "movieName")
    private String movieName;

    @Column(name = "actors")
    private String actors;

    public String getActors()
    {
        return actors;
    }

    public void setActors(String actors)
    {
        this.actors = actors;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public double getImdbRating()
    {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating)
    {
        this.imdbRating = imdbRating;
    }

    public String getRuntime()
    {
        return runtime;
    }

    public void setRuntime(String runtime)
    {
        this.runtime = runtime;
    }

    public String getPlot()
    {
        return plot;
    }

    public void setPlot(String plot)
    {
        this.plot = plot;
    }

    public String getPoster()
    {
        return poster;
    }

    public void setPoster(String poster)
    {
        this.poster = poster;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
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
        return "AdditionalInfo [id=" + id + ", director=" + director + ", year=" + year + ", genre=" + genre + "]";
    }

}
