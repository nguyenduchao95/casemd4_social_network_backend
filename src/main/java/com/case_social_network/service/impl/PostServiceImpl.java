package com.case_social_network.service.impl;

import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IPostRepo;
import com.case_social_network.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepo postRepo;
    @Value("${upload.posts.path}")
    private String fileUpload;

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
        return postRepo.findByContentContains(content);
    }

    @Override
    public List<Post> getAllByUserId(Long userId) {
        return postRepo.getAllByUserId(userId);
    }

    @Override
    public List<Post> getAllByFollow(Long id) {
        return postRepo.getAllByFollow(id);
    }

    @Override
    public Post add(MultipartFile file, String content, Long userId) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = fileUpload + "/" + fileName;
        File imageFile = new File(filePath);
        if (!imageFile.exists()){
            file.transferTo(imageFile);
        }
        Post post = new Post();
        post.setImg(fileName);
        post.setContent(content);
        post.setCreated_at(LocalDateTime.now());
        User user = new User();
        user.setId(userId);
        post.setUser(user);
        return postRepo.save(post);
    }

    @Override
    public Post edit(MultipartFile file, String content, Long postId) throws IOException {
        Post post = postRepo.findById(postId).get();
        if (file != null) {
            String fileName = file.getOriginalFilename();
            String filePath = fileUpload + "/" + fileName;
            File imageFile = new File(filePath);
            if (!imageFile.exists()){
                file.transferTo(imageFile);
            }
            post.setImg(fileName);
            post.setContent(content);
        } else {
            post.setContent(content);
        }
        return postRepo.save(post);
    }

}
