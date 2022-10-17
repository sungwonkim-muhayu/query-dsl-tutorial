package com.sungwonkim.querydsltutorial.repository.custom;

import com.sungwonkim.querydsltutorial.model.entity.Post;
import org.springframework.data.querydsl.QPageRequest;

import java.util.List;

public interface QueryDslPostRepository {
  List<Post> findAllPosts();

  List<Post> findAllPostWithCommentsByPageRequest(final QPageRequest pageRequest);
}
