package com.official.movieguide.service;

import com.official.movieguide.persistence.entity.AdditionalInfo;
import com.official.movieguide.persistence.entity.Movie;

public interface AdditionalInformationService
{
    public AdditionalInfo getAdditionalInformationForMovie(String movieName);

    public AdditionalInfo saveAdditionalInformationToDatabase(AdditionalInfo additionalInfo, Movie movie);
}
