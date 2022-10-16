package com.sungwonkim.querydsltutorial.service;

import com.sungwonkim.querydsltutorial.model.entity.Blog;
import com.sungwonkim.querydsltutorial.model.entity.Comment;
import com.sungwonkim.querydsltutorial.model.entity.Post;
import com.sungwonkim.querydsltutorial.repository.BlogRepository;
import com.sungwonkim.querydsltutorial.repository.CommentRepository;
import com.sungwonkim.querydsltutorial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BlogManagementService {

  private final BlogRepository blogRepository;
  private final CommentRepository commentRepository;
  private final PostRepository postRepository;

  public void findAllPost() {

    final List<Post> posts = postRepository.findAllPosts();

    for (final Post post : posts) {
      for (final Comment comment : post.getComments()) {
        continue;
      }
    }
  }

  public void findAllPostWithComments() {

    final List<Post> posts = postRepository.findAllPostsWithComments();

    for (final Post post : posts) {
      for (final Comment comment : post.getComments()) {
        continue;
      }
    }
  }

  @EventListener(ApplicationReadyEvent.class)
  public void setup() {
    final Blog blog = new Blog();
    blogRepository.save(blog);

    for (int i = 1; i < 11; i++) {
      final Post post = new Post();
      blog.addPost(post);

      final Set<Comment> comments = new LinkedHashSet<>();
      for (int j = 0; j < 100; j++) {
        comments.add(new Comment());
      }
      post.addComments(comments);
      postRepository.save(post);
      commentRepository.saveAll(comments);
    }
  }
}
