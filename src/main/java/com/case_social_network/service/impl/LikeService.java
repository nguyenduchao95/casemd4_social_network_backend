package com.case_social_network.service.impl;

import com.case_social_network.entity.Like;
import com.case_social_network.repository.ILikeRepo;
import com.case_social_network.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LikeService implements ILikeService {
    @Autowired
    ILikeRepo likeRepo;
    @Override
    public List<Like> getAll() {
        return (List<Like>) likeRepo.findAll();
    }

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public void delete(long id) {
        likeRepo.deleteById(id);
    }

    @Override
    public Like findById(long id) {
        return null;
    }

    @Override
    public List<Like> findByStr(String name) {
        return null;
    }

    @Override
    public List<Like> getAllByPost(long postId) {
        return likeRepo.getAllByPost(postId);
    }
}
