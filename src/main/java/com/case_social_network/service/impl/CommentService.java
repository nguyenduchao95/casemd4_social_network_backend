package com.case_social_network.service.impl;

import com.case_social_network.entity.Comment;
import com.case_social_network.entity.Post;
import com.case_social_network.repository.ICommentRepo;
import com.case_social_network.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepo commentRepo;
    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> findByStr(String name) {
        return null;
    }

    @Override
    public List<Long> findUserIdsByPostId(Long postId) {
        return commentRepo.findUserIdsByPostId(postId);
    }

    @Override
    public List<Comment> findAllByPost(Post post) {
        return commentRepo.findAllByPost(post);
    }
}
