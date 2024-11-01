package org.example.springweb.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.springweb.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    //List<Post> findAll();
}


//@Mapper
//public interface PostRepository {
//    @Select("select * from post")
//    List<Post> findAll();
//    List<Post> findAllWithLikes(@Param("likes") Integer likes, @Param("title") String title);
//    Post findById(int postId);
//    void deletePost(int postId);
//    void updatePost(Post post);
//    int insertPost(Post post);
//}

