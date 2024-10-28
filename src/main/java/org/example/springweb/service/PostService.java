package org.example.springweb.service;

import org.example.springweb.Domain.Post;
import org.example.springweb.Domain.PostDetailResponseDto;
import org.example.springweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        //return "PostService 가 호출되었습니다.";
        return postRepository.findAll();
    }

    public PostDetailResponseDto getPostDetail(int postId) {
        Post post = postRepository.findById(postId);
        PostDetailResponseDto retPost = new PostDetailResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getBody(),
                post.getLikes()
        );
        return retPost;
    }

    public void removePost(int postId) {
        postRepository.deletePost(postId);
    }
}
