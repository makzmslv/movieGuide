package com.official.movieguide.service;

import java.util.List;

import com.official.movieguide.persistence.entity.Seen;

public interface SeenService
{
    public Seen addToSeen(Integer userId, Integer movieId);

    public List<Seen> getSeenByUser(Integer userId);

    public List<Seen> getSeenByMovie(Integer movieId);
}
