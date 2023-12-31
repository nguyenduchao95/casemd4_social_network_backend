package com.case_social_network.service.impl;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import com.case_social_network.repository.ILikeRepo;
import com.case_social_network.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    ILikeRepo likeRepo;

    @Override
    public List<Long> findUserIdsByPostId(Long postId) {
        return likeRepo.findUserIdsByPostId(postId);
    }

    @Override
    public Like findLikeByPostIdAndUserId(long postId, long userId) {
        return likeRepo.findByPostIdAndUserId(postId , userId);
    }

    @Override
    public void deleteAllByPostId(Long postId) {
        likeRepo.deleteAllByPostId(postId);
    }

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public Like delete(Like like) {
        likeRepo.delete(like);
        return null;
    }

    @Override
    public Long countByPostId(Post post) {
        return likeRepo.countByPost(post);
    }


}
