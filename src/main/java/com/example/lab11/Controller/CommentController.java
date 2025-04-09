package com.example.lab11.Controller;

import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Service.CommentService;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //     Get all Comment
    @GetMapping("/get")
    public ResponseEntity<?> getAllComment() {
        return ResponseEntity.ok(commentService.getAllComment());
    }

    //     Add a new Comment
    @PostMapping("/add")
    public ResponseEntity<?> addComment(@Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment added !!"));
    }

    //     Update Comment
    @PutMapping("/update/{comment_id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer comment_id, @Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = commentService.updateComment(comment_id, comment);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("Comment Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));

    }

    //      Delete Comment
    @DeleteMapping("/delete/{comment_id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer comment_id) {
        Boolean isDelete = commentService.deleteComment(comment_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Comment delete"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    // (Endpoint # 5)   find Comment By Post Id
    @PutMapping("/get-comment-by-post-id/{postId}")
    public ResponseEntity<?> getCommentByPostId(@PathVariable Integer postId) {
        List<Comment> check = commentService.findCommentByPostId(postId);
        if (check == null) {
            return ResponseEntity.status(404).body(new ApiResponse("Not found"));
        }
        return ResponseEntity.ok((commentService.findCommentByPostId(postId)));

    }


}
