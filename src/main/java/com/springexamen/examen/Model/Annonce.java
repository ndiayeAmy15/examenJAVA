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
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)

    private String titre;
    @Column(length = 100,nullable = false)

    private String categorie;
    @Column(length = 100,nullable = false)

    private String importance;

    @Column(nullable = false)
    private String contenue;


}
