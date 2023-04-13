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


    @PostMapping("/ajouterFestival")
    public String enregistrerFestival(@ModelAttribute("festival") Festival festival) {
        festivalDao.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }

   /* @PostMapping("/submit")
    public String submitFestival(Model model) {
        return "redirect:/";
    }*/

    @GetMapping("/")
    public String afficherToutLesFestivals(Model model) {
        List<Festival> festivals = festivalDao.getAllFestivals();
        model.addAttribute("festivals", festivals);
        return "index";
    }

    @GetMapping("/editer")
    public String afficherEditer(Model model) {
        model.addAttribute("festival", new Festival());
        return "editer";
    }

    @GetMapping("/festivals/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Festival> optionalFestival = festivalRepository.findById(id);
        Festival festival = optionalFestival.orElseThrow(() -> new IllegalArgumentException("Invalid festival id: " + id));
        model.addAttribute("festival", festival);
        return "editer";
    }



    @PostMapping("/festivals/save")
    public String saveFestival(@ModelAttribute("festival") Festival festival) {
        festivalDao.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }

}