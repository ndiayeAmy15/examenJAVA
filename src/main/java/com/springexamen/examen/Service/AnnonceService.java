package com.springexamen.examen.Service;


import com.springexamen.examen.DAO.Repositories.AnnonceRepo;
import com.springexamen.examen.Model.Annonce;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    public final AnnonceRepo annonceRepo;
    public AnnonceService(@Qualifier("AnnonceRepo") AnnonceRepo annonceRepo) {
        this.annonceRepo = annonceRepo;
    }

    public boolean addAnnonce(Annonce annonce){
        annonceRepo.save(annonce);
        return true;
    }
    public List<Annonce> getAnnonces(){
       return annonceRepo.findAll();
    }
    public Optional<Annonce> getAnnonce(Long id){
        return annonceRepo.findById(id);
    }



//    public boolean deleteAnnonce(int id){
//        annonceRepo.deleteAnnonce(id);
//        return true;
//    }

//    void deleteAnnonce(Long id){
//        annonceRepo.deleteAnnonce(id);
//    }

//    @Transactional
//    public Annonce updateAnnonce(Long id, Annonce newAnnonce) {
//        return annonceRepo.findById(id)
//                .map(annonce -> {
//                    annonce.setTitre(newAnnonce.getTitre());
//                    annonce.setCategorie(newAnnonce.getCategorie());
//                    annonce.setImportance(newAnnonce.getImportance());
//                    annonce.setContenue(newAnnonce.getContenue());
//                    return annonceRepo.save(annonce);
//                })
//                .orElseThrow(() -> new RuntimeException("Annonce non trouvée avec l'id : " + id));
//    }
//
//    // Delete
//    @Transactional
//    public void deleteAnnonce(Long id) {
//        annonceRepo.deleteById(id);
//    }
}
