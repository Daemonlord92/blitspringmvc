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

    public boolean postExistsWithTitle(String title) {
        return postRepository.getPosts().stream().anyMatch(post -> post.getTitle().equalsIgnoreCase(title));
    }

    public Post getPostById(Integer id) {
        return postRepository.getPosts().stream().filter(post -> post.getId().equals(id)).findFirst().orElseThrow();
    }

    public void updatePost(Post post) {
        if(post.getStatus().toString().isEmpty()){
            post.setStatus(PostStatus.DRAFT);
        }
        postRepository.update(post);
    }

    public void deletePost(Integer id) {
        postRepository.deletePost(id);
    }

    public void publishPost(Integer id) {
        Post post = getPostById(id);
        post.setStatus(PostStatus.PUBLISHED);
        updatePost(post);
    }
}
