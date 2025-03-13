package com.springexamen.examen.Controller;


import com.springexamen.examen.Model.Annonce;
import com.springexamen.examen.Model.Discussion;
import com.springexamen.examen.Service.AnnonceService;
import com.springexamen.examen.Service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/annonces")
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }
    @GetMapping("/forum")
    public String getForum(Model model) {
        List<Discussion> forum = forumService.getDiscussion();


        model.addAttribute("forum", forum);

        return "forum"; // Assurez-vous que "home" correspond au nom de votre fichier HTML (home.html)
    }

    @PostMapping("/addforum")
    public String addAnnonce(@RequestParam String sujet, @RequestParam String message, @RequestParam int reponse, @RequestParam int vue){
        Discussion d = new Discussion();
        d.setVue(vue);
        d.setSujet(sujet);
        d.setMessage(message);
        d.setReponse(reponse);
        forumService.addForum(d);
        return  "redirect:/addforum";
    }
}
