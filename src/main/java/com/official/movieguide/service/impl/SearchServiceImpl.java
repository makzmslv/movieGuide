package com.official.movieguide.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.official.movieguide.service.SearchService;

public class SearchServiceImpl implements SearchService
{
    private List<String> fileNames = new ArrayList<String>();

    private static final Set<String> VideoFormats = new HashSet<String>(Arrays.asList("MP4", "MKV", "AVI", "FLV", "MOV", "WMV", "MPEG"));

    public List<String> getFilenames(String directoryPath)
    {
        File originalDirectory = new File(directoryPath);
        obtainFileNames(originalDirectory);
        return fileNames;
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
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
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

