package fr.simplon.festivals.dao.impl;

import fr.simplon.festivals.dao.FestivalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FestivalDaoImpl implements FestivalDao {
    @Autowired FestivalRepository festivalRepository;
}
