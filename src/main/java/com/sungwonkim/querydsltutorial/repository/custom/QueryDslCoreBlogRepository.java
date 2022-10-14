package com.sungwonkim.querydsltutorial.repository.custom;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sungwonkim.querydsltutorial.model.entity.Blog;
import com.sungwonkim.querydsltutorial.model.entity.QBlog;
import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public final class QueryDslCoreBlogRepository implements QueryDslBlogRepository {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Blog> findAllByQPageRequest(final QPageRequest qPageRequest) {
    final JPAQuery<Blog> query =
        jpaQueryFactory
            .selectFrom(QBlog.blog)
            .offset(qPageRequest.getOffset())
            .limit(qPageRequest.getPageSize());

    (((QSort) qPageRequest.getSort()).getOrderSpecifiers()).forEach(query::orderBy);

    return query.fetch();
  }
}
