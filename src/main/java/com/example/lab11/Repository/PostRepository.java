package com.example.lab11.Repository;

import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    //     Endpoint #1
    Post findPostById(Integer postId);

    //     Endpoint #2
    List<Post> findAllPostsById(Integer postId);

    // Endpoint #3
    List<Post> findPostsByTitle(String title);

    // Endpoint #4
    @Query("select p from Post p where p.publish_date<=?1")
    List<Post> getPostsBeforeDateByDate(String publishDate);

    // Endpoint #6
    @Query("select p from Post p   where p.publish_date>=?1 and p.publish_date<=?2")
    List<Post> giveCoffeePublishDateBetween(String startPublishDate, String endPublishDate);

    // Endpoint #7
    @Query("select p from Post p where p.content like %?1%")
    List<Post> findPostsByWord(String keyWord);


}
