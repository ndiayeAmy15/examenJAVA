package com.springexamen.examen.DAO.Implementation;

import com.springexamen.examen.DAO.Repositories.AnnonceRepo;
import com.springexamen.examen.DAO.Repositories.ForumRepo;
import com.springexamen.examen.Model.Discussion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DiscussionImpl implements ForumRepo  {

    private final SessionFactory sessionFactory;

    public DiscussionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Discussion> getDiscussion() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Discussion ",Discussion.class).list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addD(Discussion discussion) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(discussion);
            transaction.commit();
            return true;
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
