package com.springexamen.examen.DAO.Implementation;

import com.springexamen.examen.DAO.Repositories.AnnonceRepo;
import com.springexamen.examen.Model.Annonce;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("AnnonceRepo")
public interface AnnonceImpl extends JpaRepository<Annonce, Long>, AnnonceRepo {
//    @Override
//     default boolean addAnnonce(Annonce annonce) {
//        try{
//
//            save(annonce);
//
//            return true;
//        }catch (Exception e) {
//
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//     default List<Annonce> getAnnonces() {
//        try{
//            return  findAll();
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//
//    default Optional<Annonce> getAnnonce(Long id) {
//        try{
//            return findById(id);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
////    @Override
////    default void deleteAnnonce(Long id) {
////        try{
////             deleteById(id);;
////        }catch (Exception e) {
////            e.printStackTrace();
////
////        }
////
////    }
//
//    @Override
//    default Annonce updateAnnonce(Annonce annonce) {
//        save(annonce);
//        return annonce;
//    }


}
