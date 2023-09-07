package com.case_social_network.service.impl;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;
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
    public List<Long> findUserIdsByPostId(Long postId) {
        return likeRepo.findUserIdsByPostId(postId);
    }

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public void delete(Long id) {
        likeRepo.deleteById(id);
    }

    @Override
    public void deleteByPostIdAndUserId(long postId, long userId) {
        likeRepo.deleteByPostIdAndUserId(postId,userId);
    }



    @Override
    public Long countByPostId(Post post) {
        return likeRepo.countByPost(post);
    }


}
