package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findAllByPostId(Integer postId);
    List<Post> findAllByUserId(Integer userId);

    Post findAllByTitle(String title);
    List<Post> findAllByPublishDateBefore(Date publishDate);





}
