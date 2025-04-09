package com.example.lab11.Repository;

import com.example.lab11.Model.Comment;
import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentById(Integer commentId);

    //   Endpoint #5
    List<Comment> findCommentByPostId(Integer postId);


}
