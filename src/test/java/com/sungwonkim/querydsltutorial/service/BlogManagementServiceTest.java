package com.sungwonkim.querydsltutorial.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sungwonkim.QueryDslConfiguration;
import com.sungwonkim.querydsltutorial.model.entity.*;
import com.sungwonkim.querydsltutorial.repository.BlogRepository;
import com.sungwonkim.querydsltutorial.repository.CommentRepository;
import com.sungwonkim.querydsltutorial.repository.PostRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.LinkedHashSet;
import java.util.Set;

@Import(QueryDslConfiguration.class)
@DataJpaTest
@TestPropertySource("classpath:application.yaml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BlogManagementServiceTest {

  @Autowired BlogRepository blogRepository;

  @Autowired PostRepository postRepository;

  @Autowired CommentRepository commentRepository;

  @Autowired JPAQueryFactory jpaQueryFactory;

  @Test
  void testFetchJoin() {
    final JPAQuery<Post> query =
        jpaQueryFactory
            .selectFrom(QPost.post)
            .leftJoin(QPost.post.comments, QComment.comment)
            .fetchJoin()
            .distinct();
  }

  @BeforeAll
  void setup() {
    final Blog blog = new Blog();
    blogRepository.save(blog);

    for (int i = 0; i < 10; i++) {
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
