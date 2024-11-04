package org.example.springweb.postdomain.repository;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.example.springweb.postdomain.domain.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.example.springweb.postdomain.domain.QPost.post;

@Repository
public class PostRepositoryQueryImpl implements PostRepositoryQuery {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public PostRepositoryQueryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<PostDto> getAllPostWithLikesAndWriter(DynamicSearchCond searchCond) {
        List<PostDto> fetch = queryFactory
                .select(new QPostDto(
                        post.postId,
                        post.title,
                        post.body,
                        post.likes,
                        post.writer.userId
                ))
                .from(post)
                .where(
                        likesGoe(searchCond.getLikes()),
                        writerEq(searchCond.getUserName())
                )
                .fetch();

        return fetch;
    }

    private BooleanExpression likesGoe(Integer likes) {
        return (likes != null) ? post.likes.goe(likes): null;
    }

    private BooleanExpression writerEq(String userName) {
        return (StringUtils.hasText(userName)) ? post.writer.userName.eq(userName) : null;
    }




}
