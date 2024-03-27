package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CategoryRepository;
import com.example.blogsystem.Repository.PostRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    //• Get all the posts
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    //• Add new post
    public void addPost(Post post) {
        User u =userRepository.findUserByUserId(post.getUserId());
        Category c= categoryRepository.findCategoriesByCategoryId(post.getCategoryId());
        if (u == null && c==null) {
            throw new ApiException("Wrong id");
        }
        postRepository.save(post);

    }


// • post_id
//• category_id
//• title
//• content
//• user_id
//• publish_date

    //• Update post

    public void updatePost(Integer postId,Post post) {
        Post p =postRepository.findAllByPostId(postId);
        if (p == null) {
            throw new ApiException("post not found");
        }
        p.setCategoryId(post.getCategoryId());
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setUserId(post.getUserId());
        p.setPublishDate(post.getPublishDate());

        postRepository.save(p);
    }


    //• Delete post
    public void deletePost(Integer postId) {
        Post p =postRepository.findAllByPostId(postId);
        if (p == null) {
            throw new ApiException("Wrong id");
        }
        postRepository.delete(p);

    }


    public List<Post> getAllPostsByUserId(Integer userId) {
        return postRepository.findAllByUserId(userId);

    }


    public Post getPostByTitle(String title) {
        return postRepository.findAllByTitle(title);
    }


    public List<Post> getAllPostsBeforeDate(Date date) {
        return postRepository.findAllByPublishDateBefore(date);
    }












}
