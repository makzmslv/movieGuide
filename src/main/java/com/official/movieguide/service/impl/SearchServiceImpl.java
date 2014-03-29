package com.official.movieguide.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.dao.MovieDAO;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService
{
    @Autowired
    private MovieDAO movieDAO;

    private List<Movie> movies;

    private static final Set<String> VideoFormats = new HashSet<String>(Arrays.asList("MP4", "MKV", "AVI", "FLV", "MOV", "WMV", "MPEG", "DAT"));

    public List<Movie> search(String directoryPath)
    {
        movies = new ArrayList<Movie>();
        File originalDirectory = new File(directoryPath);
        List<Movie> moviesScanned = obtainFileNames(originalDirectory);
        List<Movie> moviesInDb = movieDAO.findAll();
        moviesScanned.removeAll(moviesInDb);

        return moviesScanned;
    }

    private List<Movie> obtainFileNames(File directory)
    {
        try
        {
            List<File> filesAndFolders = Arrays.asList(directory.listFiles());
            for (File file : filesAndFolders)
            {
                if (fileIsDirectory(file))
                {
                    obtainFileNames(file);
                }
                else
                {
                    if (isAMovie(file))
                    {
                        System.out.println("there");
                        addToList(file, movies);
                    }
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println("Exception Occurred while scanning");
        }
        return movies;
    }

    private void addToList(File file, List<Movie> movies)
    {
        Movie movie = new Movie();
        String nameOfMovie = getNameFromFile(file);
        movie.setName(nameOfMovie);
        movie.setPath(file.getParent());
        movie.setNameInSystem(file.getName());
        movies.add(movie);
    }

    private String getNameFromFile(File file)
    {
        String fileName = file.getName();
        String fileExtension = getFileExtension(fileName);
        fileExtension = "." + fileExtension;
        return fileName.replace(fileExtension, "");
    }

    private boolean fileIsDirectory(File file)
    {
        if (file.isDirectory())
            return true;
        return false;
    }

    private boolean isAMovie(File file)
    {
        String fileName = file.getName();
        String extension = getFileExtension(fileName);
        if (VideoFormats.contains(extension.toUpperCase()))
        {
            return true;
        }

        return false;
    }

    private String getFileExtension(String fileName)
    {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

}

