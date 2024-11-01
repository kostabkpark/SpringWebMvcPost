package org.example.springweb.postdomain.repository;

import org.example.springweb.postdomain.domain.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    //List<Post> findAll(); findById(); save(); delete();
    Post findByTitle(String title);
    List<Post> findByLikesGreaterThanEqual(int likes);

    @Query("select p from Post p left join fetch p.writer where p.postId = :postId")
    Post getPostWithUserFetchjoin(@Param("postId") int postId);
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

