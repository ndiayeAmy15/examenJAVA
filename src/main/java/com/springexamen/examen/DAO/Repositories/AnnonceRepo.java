package com.springexamen.examen.DAO.Repositories;

import com.springexamen.examen.Model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
//    public boolean addAnnonce(Annonce annonce);
//    public List<Annonce> getAnnonces();
//
//    public Optional<Annonce> getAnnonce(Long id);
//
//
//
//    //public boolean deleteAnnonce(int id);
//
////    void deleteAnnonce(Long id);
//
//    public Annonce updateAnnonce(Annonce produit);
}
