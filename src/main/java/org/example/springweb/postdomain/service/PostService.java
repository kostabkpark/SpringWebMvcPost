package org.example.springweb.postdomain.service;

import lombok.RequiredArgsConstructor;

import org.example.springweb.postdomain.domain.*;
import org.example.springweb.postdomain.repository.PostRepository;

import org.example.springweb.userdomain.domain.User;
import org.example.springweb.userdomain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostAllResponseDto> getAllPosts() {
        //return "PostService 가 호출되었습니다.";
        List<Post> allPosts = postRepository.findAll();
        List<PostAllResponseDto> postDtos = allPosts.stream()
                .map(PostAllResponseDto::of)
                .collect(Collectors.toList());
        return postDtos;
    }

    public PostDetailResponseDto getPostDetail(int postId) {
        Post post = postRepository.getPostWithUserFetchjoin(postId);
        if (post == null) {
            return null;
        }
        PostDetailResponseDto retPost = new PostDetailResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getBody(),
                post.getLikes(),
                post.getWriter().getUserId()
        );
        return retPost;
    }

    public PostDetailResponseDto createPostWithUser(String userId, PostCreateRequestDto postDto) {
        User user = userRepository.findByUserId(userId);
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setWriter(user);
        postRepository.save(post);
        return getPostDetail(post.getPostId());
    }

    public PostDetailResponseDto updateBodyWithUser(int postId, String userId, PostUpdateRequestDto postDto) {
        Post post = postRepository.findById(postId).get();
        if(post != null && post.getWriter().getUserId().equals(userId)) {
            post.setBody(postDto.getBody());
            Post save = postRepository.save(post);
            return getPostDetail(save.getPostId());
        }
        return null;
    }

    public void removePostWithUser(int postId, String userId) {
        Post post = postRepository.findById(postId).get();
        if(post != null && post.getWriter().getUserId().equals(userId)) {
            postRepository.delete(post);
        }
    }

//    public List<PostAllResponseDto> getAllPostsWithLikes(Integer likes, String title) {
//        //likes 값보다 큰 게시판을 전부 조회
//        List<Post> allPosts = postRepository.findAllWithLikes(likes, title);
//        List<PostAllResponseDto> postDtos = allPosts.stream()
//                .map(PostAllResponseDto::of)
//                .collect(Collectors.toList());
//        return postDtos;
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

//

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
