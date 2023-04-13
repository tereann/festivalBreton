package fr.simplon.festivals.controller;

import fr.simplon.festivals.dao.FestivalDao;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FestivalController {
    @Autowired
    private FestivalDao festivalDao;
/*
    @GetMapping("/")
    public String pageAccueil(Model model) {
        return "index.html";
    }

 */
    @GetMapping("/ajouter")
    public String afficherAjouter(Model model) {
        model.addAttribute("festival", new Festival());
        return "ajouter";
    }


    @PostMapping("/ajouterFestival")
    public String enregistrerFestival(@ModelAttribute("festival") Festival festival){
        festivalDao.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }

    @GetMapping("/")
    public String afficherToutLesFestivals(Model model) {
        List<Festival> festivals = festivalDao.getAllFestivals();
        model.addAttribute("festivals", festivals);
        return "index";
    }

   @GetMapping("/EditerFestival/{id}")
    public String EditerFestival(@PathVariable("id") Long id, Model model) {
    model.addAttribute("festival", festivalDao.findById(id));
    return "EditerFestival";
    }

    @PostMapping("/EditerFestival/{id}")
    public String EditerFestivalPost(@PathVariable("id") Long id, Festival festival) {
        festival.setId(id);
        festivalDao.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }


}
