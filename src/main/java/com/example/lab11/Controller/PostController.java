package com.example.lab11.Controller;

import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Service.PostService;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //     Get all Post
    @GetMapping("/get")
    public ResponseEntity<?> getAllPost() {
        return ResponseEntity.ok(postService.getAllPost());
    }

    //     Add a new User
    @PostMapping("/add")
    public ResponseEntity<?> addPost(@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("Post added !!"));
    }

    //     Update Post
    @PutMapping("/update/{post_id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer post_id, @Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = postService.updatePost(post_id, post);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("Post Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));

    }

    //      Delete Post
    @DeleteMapping("/delete/{post_id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer post_id) {
        Boolean isDelete = postService.deletePost(post_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Post delete"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    // ( Endpoint #2 )Find All Posts By Id
    @GetMapping("/get-by-post-id/{post_id}")
    public ResponseEntity<?> getAllPostsById(@PathVariable Integer post_id) {
        return ResponseEntity.ok(postService.getAllPostsById(post_id));
    }

    // (Endpoint #3 )find Posts By Title
    @GetMapping("/get-by-title/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(postService.getPostsByTitle(title));
    }

    // ( Endpoint #4 )find Posts By Data
    @GetMapping("/get-by-date/{date}")
    public ResponseEntity<?> getPostsByDate(@PathVariable String date) {
        return ResponseEntity.ok(postService.getPostsByDate(date));
    }

    //    Endpoint # 6
    @GetMapping("/data-between/{startPublishDate}/{endPublishDate}")
    public ResponseEntity<?> getPostsPublishDateBetween(@PathVariable String startPublishDate, @PathVariable String endPublishDate) {
        return ResponseEntity.ok(postService.getPostsPublishDateBetween(startPublishDate, endPublishDate));
    }
    //    Endpoint # 7
    @GetMapping("/get-by-keyword/{keyword}")
    public List<Post> getPostsByContentKeyword(@PathVariable  String keyword) {
        return postService.getPostsByKeyWord(keyword);
    }

}
