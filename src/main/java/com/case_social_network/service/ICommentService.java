package com.case_social_network.service;

import com.case_social_network.entity.Comment;
import com.case_social_network.entity.Post;

import java.util.List;

public interface ICommentService extends IService<Comment>{

    List<Comment> findAllByPost(Post post);


}
