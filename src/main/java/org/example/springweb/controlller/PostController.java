package org.example.springweb.controlller;

import org.example.springweb.Domain.Post;
import org.example.springweb.Domain.PostCreateRequestDto;
import org.example.springweb.Domain.PostDetailResponseDto;
import org.example.springweb.Domain.PostUpdateRequestDto;
import org.example.springweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;
    //private final A a = new A();

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> viewAllPosts() {
        //return "View All Posts";
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public PostDetailResponseDto viewPostDetail(@PathVariable("postId") int postId) {
        return postService.getPostDetail(postId);
    }

    // 게시판 글 삭제
    @DeleteMapping("/posts/{postId}")
    public String deletePost(@PathVariable("postId") int postId) {
        postService.removePost(postId);
        return "삭제 완료";
    }

    // 게시판 글에 대한 좋아요 카운트 up
    @PutMapping("/posts/{postId}")
    public int updateLikesPost(@PathVariable("postId") int postId) {
        return postService.increaseLikes(postId);
    }

    @PostMapping("/posts")
    public PostDetailResponseDto createNewPost(@RequestBody PostCreateRequestDto postDto) {
        return postService.createPost(postDto);
    }

    @PatchMapping("/posts/{postId}")
    public PostDetailResponseDto updateBodyPost(@PathVariable("postId") int postId, @RequestBody PostUpdateRequestDto postDto) {
        return postService.updatePost(postDto);
    }
}
