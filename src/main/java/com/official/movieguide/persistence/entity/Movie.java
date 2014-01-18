package com.official.movieguide.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie
{

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "nameInSystem")
    private String nameInSystem;

    @OneToOne
    @JoinColumn(name = "ref_additionalInfo")
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

    public String getNameInSystem()
    {
        return nameInSystem;
    }

    public void setNameInSystem(String nameInSystem)
    {
        this.nameInSystem = nameInSystem;
    }

    @Override
    public String toString()
    {
        return "Movie [id=" + id + ", name=" + name + ", path=" + path + ", additional_Info=" + additional_Info + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

}

