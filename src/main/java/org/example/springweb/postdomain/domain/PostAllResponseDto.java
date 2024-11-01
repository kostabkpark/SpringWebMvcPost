package org.example.springweb.postdomain.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAllResponseDto {
    private int postId;
    private String title;
    private int likes;
    private String userId;

    public static PostAllResponseDto of(Post post) {
        return new PostAllResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getLikes(),
                post.getWriter().getUserId()
        );
    }
}
