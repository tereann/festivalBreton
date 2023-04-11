package fr.simplon.festivals.controller;

import fr.simplon.festivals.dao.FestivalDao;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FestivalController {
    @Autowired
    private FestivalDao festivalDao;

    @GetMapping("/")
    public String pageAccueil(Model model) {
        model.addAttribute("festival", new Festival());
        return "index.html";
    }
}
