package fr.simplon.festivals.dao;

import fr.simplon.festivals.entity.Festival;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface FestivalDao {
    void saveFestival(String nom, String ville, String lieu, Date debut, Date fin, double lat, double lon);
    List<Festival> getAllFestivals();

    Optional<Festival> getFestivalById(Long id);


}
