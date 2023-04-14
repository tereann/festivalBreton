package fr.simplon.festivals.controller;

import fr.simplon.festivals.dao.FestivalDao;
import fr.simplon.festivals.dao.impl.FestivalRepository;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

/**
 * Class responsible for managing the flow of requests and
 * responses between the client and the server.
 * */
@Controller
public class FestivalController {
    @Autowired
    private FestivalDao festivalDao;
    @Autowired
    private FestivalRepository festivalRepository;

    @GetMapping("/ajouter")
    public String afficherAjouter(Model model) {
        model.addAttribute("festival", new Festival());
        return "ajouter";
    }

    /**
     * Method for adding new festivals to the database.
     * @param festival the festival to be saved
     *  @return the string "redirect:/" to redirect to the home page after the festival has been saved
     *  */
    @PostMapping("/ajouterFestival")
    public String enregistrerFestival(@ModelAttribute("festival") Festival festival) {
        festivalDao.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }

    /**
     * Retrieves a list of all festivals and displays them on the index page.
     * @param model the model that will contain the list of festivals to be displayed
     * @return the name of the view that will render the index page
     * */
    @GetMapping("/")
    public String afficherToutLesFestivals(Model model) {
        List<Festival> festivals = festivalDao.getAllFestivals();
        model.addAttribute("festivals", festivals);
        return "index";
    }

    /**
     * Displays the form for editing a specific festival based on the given festival ID.
     * @param id the ID of the festival to be edited
     * @param model the Model object to be used for rendering the view
     * @return the name of the view that displays the form for editing the festival
     * @throws IllegalArgumentException if the given festival ID is invalid
     */
    @GetMapping("/festivals/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Festival> optionalFestival = festivalRepository.findById(id);
        Festival festival = optionalFestival.orElseThrow(() -> new IllegalArgumentException("Invalid festival id: " + id));
        model.addAttribute("festival", festival);
        return "editer";
    }

    /**

     Saves the edited festival data to the database.
     @param editedFestival the Festival object containing the edited data to be saved
     @return a String representing the URL to be redirected to
     @throws IllegalArgumentException if the edited festival ID is invalid
     */
    @PostMapping("/festivals/save")
    public String saveEditFestival(@ModelAttribute("festival") Festival editedFestival) {
        Optional<Festival> optionalFestival = festivalRepository.findById(editedFestival.getId());
        Festival festival = optionalFestival.orElseThrow(() -> new IllegalArgumentException("Invalid festival id: " + editedFestival.getId()));

        // update the festival object with the edited data
        festival.setNom(editedFestival.getNom());
        festival.setVille(editedFestival.getVille());
        festival.setLieu(editedFestival.getLieu());
        festival.setDebut(editedFestival.getDebut());
        festival.setFin(editedFestival.getFin());

        // save the updated festival object to the database
        festivalRepository.save(festival);
        return "redirect:/";
    }

}