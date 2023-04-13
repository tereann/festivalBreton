package fr.simplon.festivals.dao.impl;

import fr.simplon.festivals.dao.FestivalDao;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class FestivalDaoImpl implements FestivalDao {
    @Autowired
    private FestivalRepository festivalRepository;

    @Override
    public void saveFestival(String nom, String ville, String lieu, Date debut, Date fin, double lat, double lon){
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festival.setLat(lat);
        festival.setLon(lon);
        festivalRepository.save(festival);
    }
    @Override
    public List<Festival> getAllFestivals(){
        return festivalRepository.findAll();
    }

    @Override
    public Optional<Festival> getFestivalById(Long id)  {
        return festivalRepository.findById(id);
    }



}
