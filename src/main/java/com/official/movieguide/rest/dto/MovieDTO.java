package com.official.movieguide.rest.dto;

import com.official.movieguide.persistence.entity.AdditionalInfo;

public class MovieDTO
{

    private Integer id;
    private String name;
    private String path;
    private AdditionalInfo additional_Info;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public AdditionalInfo getAdditional_Info()
    {
        return additional_Info;
    }

    public void setAdditional_Info(AdditionalInfo additional_Info)
    {
        this.additional_Info = additional_Info;
    }

    @Override
    public String toString()
    {
        return "Movie [id=" + id + ", name=" + name + ", path=" + path + ", additional_Info=" + additional_Info + "]";
    }

}

