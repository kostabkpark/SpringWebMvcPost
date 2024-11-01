package org.example.springweb.postdomain.service;

import lombok.RequiredArgsConstructor;

import org.example.springweb.postdomain.domain.*;
import org.example.springweb.postdomain.repository.PostRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostAllResponseDto> getAllPosts() {
        //return "PostService 가 호출되었습니다.";
        List<Post> allPosts = postRepository.findAll();
        List<PostAllResponseDto> postDtos = allPosts.stream()
                .map(PostAllResponseDto::of)
                .collect(Collectors.toList());
        return postDtos;
    }

//    public List<PostAllResponseDto> getAllPostsWithLikes(Integer likes, String title) {
//        //likes 값보다 큰 게시판을 전부 조회
//        List<Post> allPosts = postRepository.findAllWithLikes(likes, title);
//        List<PostAllResponseDto> postDtos = allPosts.stream()
//                .map(PostAllResponseDto::of)
//                .collect(Collectors.toList());
//        return postDtos;
//    }

//    public PostDetailResponseDto getPostDetail(int postId) {
//        Post post = postRepository.findById(postId);
//        if (post == null) {
//            return null;
//        }
//        PostDetailResponseDto retPost = new PostDetailResponseDto(
//                post.getPostId(),
//                post.getTitle(),
//                post.getBody(),
//                post.getLikes()
//        );
//        return retPost;
//    }

//    public void removePost(int postId) {
//        postRepository.deletePost(postId);
//    }
//
//    public int increaseLikes(int postId) {
//        Post post = postRepository.findById(postId);
//        int likes = 0;
//        if (post != null) {
//            likes = post.getLikes() + 1;
//            post.setLikes(likes);
//        }
//        postRepository.updatePost(post);
//        return likes;
//    }

//    public PostDetailResponseDto createPost(PostCreateRequestDto postDto) {
//        Post post = new Post(
//            0,
//            postDto.getTitle(),
//            postDto.getBody(),
//            0
//        );
//        postRepository.insertPost(post); // 리턴값은 0(실패) ,1(성공)
//        return getPostDetail(post.getPostId()); // generated 된 키를 이용
//    }

//    public PostDetailResponseDto updatePost(PostUpdateRequestDto postDto) {
//        Post post = postRepository.findById(postDto.getPostId());
//        // body 는 빈 내용을 허용하지 않는다.
//        if (post !=null && !postDto.getBody().equals("")) {
//            post.setBody(postDto.getBody());
//            postRepository.updatePost(post);
//        }
//        return getPostDetail(postDto.getPostId());
//    }
}