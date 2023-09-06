package com.case_social_network.service.impl;
import com.case_social_network.entity.Post;
import com.case_social_network.repository.IPostRepo;
import com.case_social_network.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepo postRepo;
    @Override
    public List<Post> getAll() {
        return (List<Post>) postRepo.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post findById(long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Post> findByStr(String content) {
        return  postRepo.findByContentContains(content);
    }

    @Override
    public List<Post> getAllByFollow(long id) {
        return postRepo.getAllByFollow(id);
    }
}
