package com.springexamen.examen.Service;
import com.springexamen.examen.Model.User;


import com.springexamen.examen.DAO.Repositories.UserRepo;
import com.springexamen.examen.Utils.CryptMDP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    private CryptMDP cmdp = new CryptMDP();


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }



    public User registerUser(String email, String motdepass, String nom, String prenom) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email déjà utilisé !");
        }

        User utilisateur = new User();
        utilisateur.setEmail(email);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        String motdepassA = cmdp.crypteMDP(motdepass);
        utilisateur.setMotdepass(motdepassA);

        return userRepository.save(utilisateur);
    }

    public Optional<User> authentifierUtilisateur(String email, String motdepass) {
        return userRepository.findByEmail(email)
                .filter(user -> cmdp.deCrypteMDP(motdepass,user.getMotdepass()));

    }

}
