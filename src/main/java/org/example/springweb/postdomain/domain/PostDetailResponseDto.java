package org.example.springweb.postdomain.domain;


import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailResponseDto {
    private int postId;
    private String title;
    private String body;
    private int likes;
    private String userId;


}
