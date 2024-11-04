package org.example.springweb.postdomain.repository;

import org.example.springweb.postdomain.domain.DynamicSearchCond;
import org.example.springweb.postdomain.domain.Post;

import java.util.List;

public interface PostRepositoryQuery {
    List<Post> getAllPostWithLikesAndWriter(DynamicSearchCond searchCond);
}
