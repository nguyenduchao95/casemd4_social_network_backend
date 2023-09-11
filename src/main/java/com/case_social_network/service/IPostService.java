package com.case_social_network.service;

import com.case_social_network.entity.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPostService extends IService<Post> {
    List<Post> getAllByUserId(Long userId);
    List<Post> getAllByFollow(Long id);
    Post add(MultipartFile file, String content, Long userId) throws IOException;
    Post edit(MultipartFile file, String content, Long postId) throws IOException;
}
