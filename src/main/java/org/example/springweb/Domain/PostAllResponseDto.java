package org.example.springweb.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAllResponseDto {
    private int postId;
    private String title;
    private int likes;

    public static PostAllResponseDto of(Post post) {
        return new PostAllResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getLikes()
        );
    }
}
