package com.sungwonkim.querydsltutorial.repository.custom;

import com.sungwonkim.querydsltutorial.model.entity.Blog;
import org.springframework.data.querydsl.QPageRequest;

import java.util.List;

public interface QueryDslBlogRepository {
  List<Blog> findAllByQPageRequest(final QPageRequest qPageRequest);
}
