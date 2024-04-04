package com.blitmatthew.springmvc.controller;

import com.blitmatthew.springmvc.entity.Post;
import com.blitmatthew.springmvc.entity.PostStatus;
import com.blitmatthew.springmvc.service.PostService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
@RequestMapping("/posts")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    private final PostService postService;

    public HelloController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "post";
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
        if(errors.hasErrors()) {
            return "addPost";
        }
        postService.createPost(post);
        return "redirect:/posts/";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);
        logger.info(post.toString());
        model.addAttribute("post", post);
        return "editForm";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable Integer id, @ModelAttribute("post") @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "editForm";
        }

        postService.updatePost(post);
        return "redirect:/posts/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return "redirect:/posts/";
    }

    @GetMapping("/publish/{id}")
    public String publishPost(@PathVariable Integer id) {
        postService.publishPost(id);
        return "redirect:/posts/";
    }
}
