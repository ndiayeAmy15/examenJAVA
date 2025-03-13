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
@Table(name = "discussion")
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)

    private String sujet;

    @Column(nullable = false)

    private String message;

    @Column(nullable = false)
    private int reponse;

    @Column(nullable = false)
    private int vue;

}
