package fr.simplon.festivals.dao;

import fr.simplon.festivals.entity.Festival;

import java.util.List;

public interface FestivalDao {
    void saveFestival(Festival festival);
    List<Festival> getAllFestivals();
}
