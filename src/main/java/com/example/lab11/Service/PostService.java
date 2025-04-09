package com.example.lab11.Service;

import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    //     Get all Post
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    //     Add a new Post
    public void addPost(Post post) {
        postRepository.save(post);
    }

    //     Update a Post
    public Boolean updatePost(Integer post_id, Post post) {
        Post oldPost = postRepository.findPostById(post_id);
        Category category = categoryRepository.findCategoryById(post.getCategoryId());
        User user = userRepository.findUserById(post.getUserId());

        if (oldPost == null) {
            return false;
        }
        if (category != null) {
            oldPost.setCategoryId(post.getCategoryId());
        }
        if (user != null) {
            oldPost.setUserId(post.getUserId());
        }
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        oldPost.setPublish_date(user.getRegistration_date());

        postRepository.save(oldPost);
        return true;
    }

    //     Delete a Post
    public Boolean deletePost(Integer post_id) {
        Post deletePost = postRepository.findPostById(post_id);
        if (deletePost == null) {
            return false;
        }
        postRepository.delete(deletePost);
        return true;
    }

    // ( Endpoint #2 )Find All Posts ById
    public List<Post> getAllPostsById(Integer post_id) {
        return postRepository.findAllPostsById(post_id);
    }

    // (Endpoint #3 )find Posts By Title
    public List<Post> getPostsByTitle(String title) {
        return postRepository.findPostsByTitle(title);
    }

    // (Endpoint # 4) find Posts By Date
    public List<Post> getPostsByDate(String date) {
        return postRepository.getPostsBeforeDateByDate(date);
    }

    //    Endpoint # 6
    public List<Post> getPostsPublishDateBetween(String startPublishDate, String endPublishDate) {
        return postRepository.giveCoffeePublishDateBetween(startPublishDate, endPublishDate);
    }

    // (Endpoint #7)
    public List<Post> getPostsByKeyWord(String keyword) {
        return postRepository.findPostsByWord(keyword);
    }
    // (Endpoint #8)
    public List<Post> getPostsByCategoryName(String categoryName) {
        return postRepository.findPostsByCategoryName(categoryName);
    }


}