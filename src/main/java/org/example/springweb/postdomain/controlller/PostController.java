package org.example.springweb.postdomain.controlller;

import lombok.RequiredArgsConstructor;

import org.example.springweb.postdomain.domain.PostAllResponseDto;
import org.example.springweb.postdomain.domain.PostCreateRequestDto;
import org.example.springweb.postdomain.domain.PostDetailResponseDto;
import org.example.springweb.postdomain.domain.PostUpdateRequestDto;
import org.example.springweb.postdomain.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<PostAllResponseDto> viewAllPosts() {
        //return "View All Posts";
        return postService.getAllPosts();
    }

}
