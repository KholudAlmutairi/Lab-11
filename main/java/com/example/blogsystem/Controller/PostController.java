package com.example.blogsystem.Controller;

import com.example.blogsystem.ApiResponse.ApiResponse;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import java.util.Date;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getAllPost() {

        return ResponseEntity.status(200).body(postService.getAllPost());
    }


    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("Post Added"));

    }


    @PutMapping("/update/{postId}")
    public ResponseEntity updatePost(@PathVariable Integer postId, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(postId, post);
        return ResponseEntity.status(200).body(new ApiResponse("Post updated"));
    }


    @DeleteMapping("/delete/{postId}")
    public ResponseEntity deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(200).body(new ApiResponse("Post deleted!"));
    }

    //endpoint #4
    @GetMapping("/posts/user/{userId}")
    public ResponseEntity getAllPostsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(postService.getAllPostsByUserId(userId));
    }

    //endpoint #5
    @GetMapping("/posts/title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(postService.getPostByTitle(title));

    }

    //endpoint #6
    @GetMapping("/posts/before-date")
    public ResponseEntity<List<Post>> getAllPostsBeforeDate(@RequestParam("publishDate") Date publishDate) {
        return ResponseEntity.status(200).body(postService.getAllPostsBeforeDate(publishDate));
    }


}