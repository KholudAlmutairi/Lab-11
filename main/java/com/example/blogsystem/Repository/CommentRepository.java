package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findAllByCommentId(Integer commentId);
    List<Comment>findAllByPostId(Integer postId);

    @Query("SELECT c FROM Comment c WHERE c.commentDate = :commentDate")
    List<Comment> findAllByCommentDate(@Param("commentDate") Date commentDate);


}
