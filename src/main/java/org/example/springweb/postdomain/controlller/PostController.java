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
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostAllResponseDto> viewAllPosts() {
        //return "View All Posts";
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDetailResponseDto viewPost(@PathVariable("postId") int postId) {
        return postService.getPostDetail(postId);
    }

    @PostMapping("/users/{userId}")
    public PostDetailResponseDto createNewPostWithUser(
            @PathVariable("userId") String userId,
            @RequestBody PostCreateRequestDto postDto) {
//        postDto.setUserId(userId);
        return postService.createPostWithUser(userId, postDto);
    }

    @PatchMapping("/{postId}/users/{userId}")
    public PostDetailResponseDto updatePostWithUser(
            @PathVariable("postId") int postId,
            @PathVariable("userId") String userId,
            @RequestBody PostUpdateRequestDto postDto
    ) {
        return postService.updateBodyWithUser(postId, userId, postDto);
    }

    @DeleteMapping("/{postId}/users/{userId}")
    public void deletePostWithUser(
            @PathVariable("postId") int postId,
            @PathVariable("userId") String userId
    ){
        postService.removePostWithUser(postId, userId);
    }

}
