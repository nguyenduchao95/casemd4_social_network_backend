package com.case_social_network.service.impl;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
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
        // Sử dụng LikeRepository để lấy danh sách userId đã like bài viết dựa trên postId
        return likeRepo.findUserIdsByPostId(postId);
    }

    @Override
    public Long countByPostId(Post post) {
        return likeRepo.countByPost(post);
    }

    @Override
    public List<Like> getAllByPost(Post post) {
        return likeRepo.findByPost(post);
    }
}
