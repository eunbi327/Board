package com.board.springboot.web;

import com.board.springboot.config.auth.dto.LoginUser;
import com.board.springboot.config.auth.dto.SessionUser;
import com.board.springboot.domain.commnets.dto.CommentsResponseDto;
import com.board.springboot.domain.posts.service.PostsService;
import com.board.springboot.domain.posts.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser member) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (member != null) {
            model.addAttribute("userName", member.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser member) {
        if (member != null) {
            model.addAttribute("userName", member.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{postId}")
    public String postsUpdate(@PathVariable Long postId, Model model) {
        PostsResponseDto dto = postsService.findById(postId);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/posts/{postId}")
    public String postsDetail(@PathVariable Long postId, Model model, @LoginUser SessionUser member) {
        PostsResponseDto dto = postsService.findById(postId);
        List<CommentsResponseDto> comments = dto.getComments();

        model.addAttribute("post", dto);

        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }

        if (member != null) {
            model.addAttribute("userName", member.getName());
        }
        return "posts-detail";
    }
}
