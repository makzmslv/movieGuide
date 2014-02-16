package com.official.movieguide.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.official.movieguide.persistence.entity.AdditionalInfo;

@Repository
public interface AdditonalInfoDAO extends JpaRepository<AdditionalInfo, Integer>
{
    public List<AdditionalInfo> findAll();
}
