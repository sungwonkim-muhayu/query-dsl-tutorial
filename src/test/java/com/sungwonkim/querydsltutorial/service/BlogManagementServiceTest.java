package com.sungwonkim.querydsltutorial.service;

import com.sungwonkim.querydsltutorial.model.entity.Blog;
import com.sungwonkim.querydsltutorial.repository.BlogRepository;
import com.sungwonkim.querydsltutorial.repository.CommentRepository;
import com.sungwonkim.querydsltutorial.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application.yaml")
class BlogManagementServiceTest {

  @Autowired BlogRepository blogRepository;

  @Autowired PostRepository postRepository;

  @Autowired CommentRepository commentRepository;

  @Test
  void setup() {
    final Blog blog = new Blog();
    blogRepository.save(blog);
  }

  @Test
  void test() {}
}
