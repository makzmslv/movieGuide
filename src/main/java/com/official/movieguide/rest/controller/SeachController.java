package com.official.movieguide.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.SearchService;

@Controller
@RequestMapping(value = "/search")
public class SeachController
{
    @Autowired
    private SearchService searchService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Movie> search(@RequestBody String directoryPath)
    {
        return searchService.search(directoryPath);
    }

}
