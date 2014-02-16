package com.official.movieguide.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.movieguide.persistence.entity.AdditionalInfo;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.AdditionalInformationService;

@Controller
@RequestMapping(value = "/additionalInfo")
public class AdditionalInformationController
{
    @Autowired
    private AdditionalInformationService additionalInformationService;

    @RequestMapping(value = "/{movieName}", method = RequestMethod.GET)
    @ResponseBody
    public AdditionalInfo getAdditionalInfoForMovie(@PathVariable("movieName") String movieName)
    {
        return additionalInformationService.getAdditionalInformationForMovie(movieName);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AdditionalInfo saveAdditionalInfo(@RequestBody AdditionalInfo additionalInfo, @RequestBody Movie movie)
    {
        return additionalInformationService.saveAdditionalInformationToDatabase(additionalInfo, movie);
    }
}
