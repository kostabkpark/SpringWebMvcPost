package org.example.springweb.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=20, nullable=false)
    private String userName;
    @Column(length=8, nullable=false, unique=true)
    private String userId;
    @Column(length=8, nullable=false)
    private String password;
}
