package com.springexamen.examen.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)

    private String prenom;
    @Column(length = 100,nullable = false)
    private String nom;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String motdepass;

}
