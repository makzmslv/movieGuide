package com.official.movieguide.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService
{
    private List<String> fileNames = new ArrayList<String>();

    private List<Movie> movies = new ArrayList<Movie>();

    private static final Set<String> VideoFormats = new HashSet<String>(Arrays.asList("MP4", "MKV", "AVI", "FLV", "MOV", "WMV", "MPEG"));

    public List<Movie> getFilenames(String directoryPath)
    {
        File originalDirectory = new File(directoryPath);
        obtainFileNames(originalDirectory);
        return movies;
    }

    private List<String> obtainFileNames(File originalDirectory)
    {
        List<File> filesAndFolders = Arrays.asList(originalDirectory.listFiles());
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
                    addToList(file);
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }

    private void addToList(File file)
    {
        Movie movie = new Movie();
        movie.setName(file.getName());
        movie.setPath(file.getPath());
        movies.add(movie);
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
            return true;

        return false;
    }

    private String getFileExtension(String fileName)
    {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

}

