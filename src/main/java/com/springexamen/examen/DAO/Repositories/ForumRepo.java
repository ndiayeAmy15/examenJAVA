package com.springexamen.examen.DAO.Repositories;

import com.springexamen.examen.Model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ForumRepo {


   public List<Discussion> getDiscussion();
   boolean addD(Discussion discussion);
}
