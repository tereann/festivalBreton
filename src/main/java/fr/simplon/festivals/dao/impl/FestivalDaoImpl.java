package fr.simplon.festivals.dao.impl;

import fr.simplon.festivals.dao.FestivalDao;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FestivalDaoImpl implements FestivalDao {
    @Autowired
    private FestivalRepository festivalRepository;

    @Override
    public void saveFestival(Festival festival) {
        festivalRepository.save(festival);
    }

    @Override
    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }
}

