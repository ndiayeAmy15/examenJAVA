package com.springexamen.examen.Service;


import com.springexamen.examen.DAO.Repositories.ForumRepo;
import com.springexamen.examen.Model.Discussion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {
        private final ForumRepo forumRepo;


    public ForumService(ForumRepo forumRepo) {
        this.forumRepo = forumRepo;

    }

    public boolean addForum(Discussion discussion){
        try {
            forumRepo.addD(discussion);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    public List<Discussion> getDiscussion(){
        try {
            return  forumRepo.getDiscussion();
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }


}
