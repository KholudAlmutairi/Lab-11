package com.example.blogsystem.Controller;

import com.example.blogsystem.ApiResponse.ApiResponse;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Service.CategoryService;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//import javax.xml.stream.events.Comment;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getAllComments(){

        return ResponseEntity.status(200).body(commentService.getAllComments());}


    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("Comment Added"));

    }


    @PutMapping("/update/{commentId}")
    public ResponseEntity updateComment(@PathVariable Integer commentId, @RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        commentService.updateComment(commentId,comment);
        return ResponseEntity.status(200).body(new ApiResponse( "Comment updated"));
    }


    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Integer commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.status(200).body(new ApiResponse("Comment deleted!"));
    }
    //endpoint #7
    @GetMapping("/comments/post/{postId}")
    public ResponseEntity getAllCommentsForPost(@PathVariable Integer postId) {
        return ResponseEntity.status(200).body(commentService.getAllCommentsForPost(postId));
    }
    //endpoint #8

    @GetMapping("/comments/date")
    public ResponseEntity<List<Comment>> getAllCommentsByDate(@RequestParam("commentDate") Date commentDate) {
        List<Comment> comments = commentService.getAllCommentsByDate(commentDate);
        return ResponseEntity.ok(comments);
    }





}
