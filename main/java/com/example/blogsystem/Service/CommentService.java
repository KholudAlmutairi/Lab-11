package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CommentRepository;
import com.example.blogsystem.Repository.PostRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
@Service
@RequestMapping("/api/v1/commrt")
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //• Get all the Comments
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    //• Add new  Comment
    public void addComment(Comment comment) {
        User u =userRepository.findUserByUserId(comment.getUserId());
        Post p =postRepository.findAllByPostId(comment.getPostId());
        if (u == null && p==null) {
            throw new ApiException("Wrong id");
        }

        commentRepository.save(comment);
    }

    //• Update Comment
    public void updateComment(Integer commentId, Comment comment) {
        Comment c=commentRepository.findAllByCommentId(commentId);
        if (c == null) {
            throw new ApiException("Wrong id");
        }

        c.setUserId(comment.getUserId());
        c.setPostId(comment.getPostId());
        c.setContent(comment.getContent());
        c.setCommentDate(comment.getCommentDate());
        commentRepository.save(c);

    }


    //• Delete Comment
    public void deleteComment(Integer commentId) {
        Comment c=commentRepository.findAllByCommentId(commentId);
        if (c == null) {
            throw new ApiException("Wrong id");
        }
        commentRepository.delete(c);

    }


    public List<Comment> getAllCommentsForPost(Integer postId) {
        return commentRepository.findAllByPostId(postId);
    }


    public List<Comment> getAllCommentsByDate(Date commentDate) {
        return commentRepository.findAllByCommentDate(commentDate);
    }










}