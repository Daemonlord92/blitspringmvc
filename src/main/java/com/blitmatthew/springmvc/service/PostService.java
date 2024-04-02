package com.blitmatthew.springmvc.service;

import com.blitmatthew.springmvc.entity.Post;
import com.blitmatthew.springmvc.entity.PostStatus;
import com.blitmatthew.springmvc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.getPosts();
    }

    public void createPost(Post post) {
        post.setStatus(PostStatus.DRAFT);
        post.setCreatedOn(LocalDateTime.now());
        postRepository.addPost(post);
    }
}
