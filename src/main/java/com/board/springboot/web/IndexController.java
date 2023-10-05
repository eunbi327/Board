package com.board.springboot.web;

import com.board.springboot.domain.posts.service.PostsService;
import com.board.springboot.domain.posts.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{postId}")
    public String postsUpdate(@PathVariable Long postId, Model model) {
        PostsResponseDto dto = postsService.findById(postId);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/posts/{postId}")
    public String postsDetail(@PathVariable Long postId, Model model) {
        PostsResponseDto dto = postsService.findById(postId);
        model.addAttribute("post", dto);
        return "posts-detail";
    }

    @GetMapping("/members/register")
    public String membersRegister() {
        return "members-register";
    }
}
