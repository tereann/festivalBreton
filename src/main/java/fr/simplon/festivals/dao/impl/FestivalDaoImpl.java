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

    /**

     Overrides the saveFestival method to create and save a new festival object to the database.
     @param nom the name of the festival
     @param ville the city where the festival takes place
     @param lieu the location of the festival within the city
     @param debut the start date of the festival
     @param fin the end date of the festival
     @param lat the latitude of the festival location
     @param lon the longitude of the festival location
     */
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

    /**

     Retrieves a list of all festivals from the database.
     @return a List of Festival objects representing all festivals in the database.
     */
    @Override
    public List<Festival> getAllFestivals(){
        return festivalRepository.findAll();
    }

    /**

     Returns an {@code Optional} containing the {@code Festival} object associated with the given ID, if present in the database.
     @param id the ID of the festival to be retrieved
     @return an {@code Optional} containing the {@code Festival} object associated with the given ID, or empty if no such object exists
     */
    @Override
    public Optional<Festival> getFestivalById(Long id)  {
        return festivalRepository.findById(id);
    }
}
