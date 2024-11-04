package org.example.springweb.postdomain.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.lang.annotation.Annotation;

@Data // Qobject 용도
public class PostDto {
    private int postId;
    private String title;
    private String body;
    private int likes;
    private String userId;

    @QueryProjection
    PostDto(int postId, String title, String body, int likes, String userId) {
        this.postId = postId;
        this.title = title;
        this.body = body;
        this.likes = likes;
        this.userId = userId;
    }

}
