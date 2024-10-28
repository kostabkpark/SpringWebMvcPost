package org.example.springweb.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private int postId;
    private String title;
    private String body;
    private int likes;
}
