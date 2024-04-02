package com.blitmatthew.springmvc.repository;

import com.blitmatthew.springmvc.entity.Post;
import com.blitmatthew.springmvc.entity.PostStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository {
    private final List<Post> postList = new ArrayList<>();

    public PostRepository() {
        Post post = new Post();
        post.setTitle("Spring MVC Fun");
        post.setBody("lorem ipsum sdajkfhaskdjvnasdvsadvasv  dfhaksgdfjgsd");
        post.setStatus(PostStatus.DRAFT);
        post.setCreatedOn(LocalDateTime.now());
        Post post1 = new Post();
        post1.setTitle("Billy bob joe");
        post1.setBody("Billy was the hero of jupiter");
        post1.setStatus(PostStatus.PUBLISHED);
        post1.setCreatedOn(LocalDateTime.now());
        Post post2 = new Post();
        post2.setTitle("Python is horrible");
        post2.setBody("Tab spacing is horrible");
        post2.setCreatedOn(LocalDateTime.now());
        post2.setStatus(PostStatus.DRAFT);
        postList.addAll(Arrays.asList(post, post1, post2));
    }

    public List<Post> getPosts() {
        return postList;
    }

    public void addPost(Post post) {
        postList.add(post);
    }
}
