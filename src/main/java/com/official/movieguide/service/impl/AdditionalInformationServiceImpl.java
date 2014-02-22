package com.official.movieguide.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.official.movieguide.persistence.dao.AdditonalInfoDAO;
import com.official.movieguide.persistence.dao.MovieDAO;
import com.official.movieguide.persistence.entity.AdditionalInfo;
import com.official.movieguide.persistence.entity.Movie;
import com.official.movieguide.service.AdditionalInformationService;

@Service
public class AdditionalInformationServiceImpl implements AdditionalInformationService
{
    @Autowired
    private AdditonalInfoDAO additonalInfoDAO;

    @Autowired
    private MovieDAO movieDAO;

    private static final String WEBPAGE = "http://www.omdbapi.com/?t=";

    @Override
    public AdditionalInfo getAdditionalInformationForMovie(String movieName)
    {
        String movieURL = obtainURLForMovie(movieName);
        System.out.println(movieURL);
        String additionalInfoJSONString = obtainJsonFromWeb(movieURL);
        System.out.println(additionalInfoJSONString);
        JsonObject additionalInfoJSONObject = parseJSONStringToJSONObject(additionalInfoJSONString);
        if (ifAdditionalInfoFound(additionalInfoJSONObject))
        {
            AdditionalInfo additionalInfoEntity = createAdditonalInfoEntity(additionalInfoJSONObject);
            return additionalInfoEntity;
        }
        return null;
    }

    private String obtainURLForMovie(String movieName)
    {
        String webpage = WEBPAGE;
        if (movieNameContainsSpaces(movieName))
        {
            try
            {
                movieName = URLEncoder.encode(movieName, "UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return webpage.concat(movieName);
    }

    private boolean movieNameContainsSpaces(String movieName)
    {
        if (movieName.contains(" "))
            return true;
        return false;
    }

    private String obtainJsonFromWeb(String webpage)
    {
        String jsonString = new String();
        try
        {
            URL url = new URL(webpage);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String inputFromWebpage;
            while ((inputFromWebpage = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(inputFromWebpage);
            }
            jsonString = stringBuilder.toString();
        }
        catch (IOException ioException)
        {
            System.out.println(ioException);
        }

        return jsonString;
    }

    private JsonObject parseJSONStringToJSONObject(String additionalInfoJSON)
    {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = null;
        try
        {
            jsonObject = jsonParser.parse(additionalInfoJSON).getAsJsonObject();
        }
        catch(Exception exception)
        {
            System.out.println("Error Occured during parsing: " + exception);
        }
        return jsonObject;
    }

    private boolean ifAdditionalInfoFound(JsonObject additionalInfoJSONObject)
    {
        if (additionalInfoJSONObject == null)
            return false;
        String response = additionalInfoJSONObject.get("Response").getAsString();
        if (response.contentEquals("False"))
            return false;
        return true;

    }

    private AdditionalInfo createAdditonalInfoEntity(JsonObject additionalInfoJSONObject)
    {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setDirector(additionalInfoJSONObject.get("Director").getAsString());
        additionalInfo.setGenre(additionalInfoJSONObject.get("Genre").getAsString());
        additionalInfo.setImdbRating(additionalInfoJSONObject.get("imdbRating").getAsString());
        additionalInfo.setPlot(additionalInfoJSONObject.get("Plot").getAsString());
        additionalInfo.setPoster(additionalInfoJSONObject.get("Poster").getAsString());
        additionalInfo.setRuntime(additionalInfoJSONObject.get("Runtime").getAsString());
        additionalInfo.setYear(additionalInfoJSONObject.get("Year").getAsInt());
        additionalInfo.setMovieName(additionalInfoJSONObject.get("Title").getAsString());
        return additionalInfo;
    }

    @Override
    public AdditionalInfo saveAdditionalInformationToDatabase(AdditionalInfo additionalInfo, Movie movie)
    {
        additionalInfo = additonalInfoDAO.saveAndFlush(additionalInfo);
        movie.setAdditional_Info(additionalInfo);
        movie.setName(additionalInfo.getMovieName());
        movieDAO.saveAndFlush(movie);
        return additionalInfo;
    }

}
