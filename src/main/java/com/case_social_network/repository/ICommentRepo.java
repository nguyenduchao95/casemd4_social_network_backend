package com.case_social_network.repository;

import com.case_social_network.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepo extends CrudRepository<Comment,Long> {

}
