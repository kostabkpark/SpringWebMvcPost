package org.example.springweb.postdomain.repository;

import org.example.springweb.postdomain.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

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

