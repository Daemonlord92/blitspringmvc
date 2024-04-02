package com.blitmatthew.springmvc.controller;

import com.blitmatthew.springmvc.entity.Post;
import com.blitmatthew.springmvc.entity.PostStatus;
import com.blitmatthew.springmvc.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
@RequestMapping("/posts")
public class HelloController {

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
    public String addPost(@ModelAttribute("post") Post post) {
        postService.createPost(post);
        return "redirect:/posts/";
    }
}
