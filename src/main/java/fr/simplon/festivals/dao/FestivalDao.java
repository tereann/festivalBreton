package fr.simplon.festivals.dao;

import fr.simplon.festivals.entity.Festival;

import java.sql.Date;
import java.util.List;

public interface FestivalDao {
    void saveFestival(String nom, String ville, String lieu, java.sql.Date debut, Date fin, double lat, double lon);
    List<Festival> getAllFestivals();
    
}
