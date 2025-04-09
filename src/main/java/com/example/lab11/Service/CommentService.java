package com.example.lab11.Service;

import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CommentRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.ru.INN;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //     Get all Comment
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    //     Add a new Comment
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    //     Update a Comment
    public Boolean updateComment(Integer comment_id, Comment comment) {
        Comment oldComment = commentRepository.findCommentById(comment_id);
        User user = userRepository.findUserById(comment.getUserId());

        if (oldComment == null) {
            return false;
        }
        if (user != null) {
            oldComment.setUserId(comment.getUserId());
        }
        oldComment.setContent(comment.getContent());
        oldComment.setComment_date(comment.getComment_date());


        commentRepository.save(oldComment);
        return true;
    }

    //     Delete a Comment
    public Boolean deleteComment(Integer comment_id) {
        Comment deleteComment = commentRepository.findCommentById(comment_id);
        if (deleteComment == null) {
            return false;
        }
        commentRepository.delete(deleteComment);
        return true;
    }


    // (Endpoint # 5)
    public List<Comment> findCommentByPostId(Integer postId) {
        Post post = postRepository.findPostById(postId);
        List<Comment> comments = commentRepository.findCommentByPostId(postId);
        if (post == null && comments == null) {
            return null;
        }
        return comments;
    }


}
