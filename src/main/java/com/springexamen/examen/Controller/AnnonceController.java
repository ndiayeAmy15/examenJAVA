package com.springexamen.examen.Controller;

import com.springexamen.examen.DAO.Repositories.AnnonceRepo;
import com.springexamen.examen.Model.Annonce;
import com.springexamen.examen.Service.AnnonceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceService annonceService;


    public AnnonceController(AnnonceService annonceService, @Qualifier("AnnonceRepo") AnnonceRepo annonceRepo) {
        this.annonceService = annonceService;
    }


    @GetMapping("/home")
    public String getAnnonces(Model model) {
        List<Annonce> annonceL = annonceService.getAnnonces();
        String text ="test";

       model.addAttribute("annonces", annonceL);
        model.addAttribute("test", text);
        return "home"; // Assurez-vous que "home" correspond au nom de votre fichier HTML (home.html)
    }

    @PostMapping("/addAnnonce")
    public String addAnnonce(@RequestParam String titre, @RequestParam String categorie, @RequestParam String importance, @RequestParam String contenue){
        Annonce annonce = new Annonce();
        annonce.setCategorie(categorie);
        annonce.setContenue(contenue);
        annonce.setTitre(titre);
        annonce.setImportance(importance);
        annonceService.addAnnonce(annonce);
        return  "redirect:/home";
    }



}
