package org.example.springweb.service;

import org.example.springweb.Domain.Post;
import org.example.springweb.Domain.PostCreateRequestDto;
import org.example.springweb.Domain.PostDetailResponseDto;
import org.example.springweb.Domain.PostUpdateRequestDto;
import org.example.springweb.repository.PostRepository;
import org.example.springweb.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostRepositoryImpl postRepositoryImpl;

    @Autowired
    public PostService(PostRepository postRepository, PostRepositoryImpl postRepositoryImpl) {
        this.postRepository = postRepository;
        this.postRepositoryImpl = postRepositoryImpl;
    }

    public List<Post> getAllPosts() {
        //return "PostService 가 호출되었습니다.";
        return postRepository.findAll();
    }

    public PostDetailResponseDto getPostDetail(int postId) {
        Post post = postRepository.findById(postId);
        if (post == null) {
            return null;
        }
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

    public int increaseLikes(int postId) {
        Post post = postRepository.findById(postId);
        int likes = 0;
        if (post != null) {
            likes = post.getLikes() + 1;
            post.setLikes(likes);
        }
        return likes;
    }

    public PostDetailResponseDto createPost(PostCreateRequestDto postDto) {
        Post post = new Post(
            0,
            postDto.getTitle(),
            postDto.getBody(),
            0
        );
        int postId = postRepository.insertPost(post);
        return getPostDetail(postId);
    }

    public PostDetailResponseDto updatePost(PostUpdateRequestDto postDto) {
        Post post = postRepository.findById(postDto.getPostId());
        // body 는 빈 내용을 허용하지 않는다.
        if (post !=null && !postDto.getBody().equals("")) {
            post.setBody(postDto.getBody());
            postRepository.updatePost(post);
        }
        return getPostDetail(postDto.getPostId());
    }
}
