package org.example.springweb.postdomain.controlller;

import lombok.RequiredArgsConstructor;

import org.example.springweb.postdomain.domain.*;
import org.example.springweb.postdomain.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping
    public String viewAllPosts(Model model) {
        List<PostAllResponseDto> allPosts = postService.getAllPosts();
        model.addAttribute("allPosts", allPosts);
        return "post/postAll";
    }

//    @GetMapping
//    public List<PostAllResponseDto> viewAllPostsWithSearchCond(
//            @RequestBody DynamicSearchCond searchCond) {
//        //return "View All Posts";
//        return postService.getAllPostWithSearchCond(searchCond);
//    }

    @GetMapping("/{postId}")
    public String viewPost(@PathVariable("postId") int postId,
                           Model model) {
        model.addAttribute("post", postService.getPostDetail(postId));
        return "post/postDetail";
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
