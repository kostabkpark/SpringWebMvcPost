package org.example.springweb.postdomain.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.springweb.userdomain.domain.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(length=20, nullable=false)
    private String title;
    private String body;
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User writer;
}
