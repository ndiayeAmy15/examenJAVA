package com.springexamen.examen.Controller;


import com.springexamen.examen.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springexamen.examen.Model.User;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping({"", "/login"})
    public String index() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String motdepass,@RequestParam String nom,@RequestParam String prenom) {
        userService.registerUser(email, motdepass,nom,prenom);
        return "redirect:/login";
    }

    // Méthode de déconnexion
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Supprimer la session de l'utilisateur
        HttpSession session = request.getSession(false); // Récupère la session existante si elle existe
        if (session != null) {
            session.invalidate(); // Invalide la session pour déconnecter l'utilisateur
        }
        return "redirect:/login"; // Redirige l'utilisateur vers la page de connexion
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        // Vérifiez si l'utilisateur est connecté
        if (session.getAttribute("utilisateur") == null) {
            return "redirect:/login"; // Redirigez vers la page de connexion si l'utilisateur n'est pas connecté
        }
        return "home"; // Autorisez l'accès à la page home si l'utilisateur est connecté
    }


    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Optional<User> utilisateur = userService.authentifierUtilisateur(email, password);

        if (utilisateur.isPresent()) {
            session.setAttribute("utilisateur", utilisateur.get());
            return "redirect:/home";
        } else {
            session.setAttribute("error", "Email ou mot de passe incorrect !");
            return "redirect:/login";
        }
    }
}
