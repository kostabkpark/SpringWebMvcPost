package org.example.springweb.postdomain.repository;

import org.example.springweb.postdomain.domain.DynamicSearchCond;
import org.example.springweb.postdomain.domain.Post;
import org.example.springweb.postdomain.domain.PostDetailResponseDto;
import org.example.springweb.postdomain.domain.PostDto;

import java.util.List;

public interface PostRepositoryQuery {
    List<PostDto> getAllPostWithLikesAndWriter(DynamicSearchCond searchCond);
}
