package com.springexamen.examen.DAO.Repositories;
import com.springexamen.examen.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    // Recherche par email
    Optional<User> findByEmail(String email);

}
