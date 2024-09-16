package com.sai.samithi.home.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    PostsService postService;

    @PostMapping
    public PostsResponse createPosts(@RequestBody @Valid PostsRequest postsRequest) {
        return postService.add(postsRequest);
    }

    @GetMapping
    public List<PostsResponse> getPosts(@RequestParam(defaultValue = "0") int page, Model model) {             
        return postService.getAll();
    }

    @GetMapping("/{path}")
    public String getPost(@PathVariable("path") String path) {
        return "posts/" + path;
    }

}
