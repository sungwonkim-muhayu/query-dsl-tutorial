package com.sungwonkim.querydsltutorial.repository.custom;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sungwonkim.querydsltutorial.model.entity.Post;
import com.sungwonkim.querydsltutorial.model.entity.QComment;
import com.sungwonkim.querydsltutorial.model.entity.QPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryDslPostRepositoryImpl implements QueryDslPostRepository {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<Post> findAllPosts() {
    final JPAQuery<Post> query = jpaQueryFactory.selectFrom(QPost.post);

    return query.fetch();
  }

  @Override
  public List<Post> findAllPostsWithComments() {
    final List<Long> ids =
        jpaQueryFactory
            .select(QPost.post.id)
            .from(QPost.post)
            .offset(0)
            .limit(10)
            .distinct()
            .fetch();

    final JPAQuery<Post> query =
        jpaQueryFactory
            .selectFrom(QPost.post)
            .leftJoin(QPost.post.comments, QComment.comment)
            .fetchJoin()
            .where(QPost.post.id.in(ids))
            .distinct();

    return query.fetch();
  }
}
