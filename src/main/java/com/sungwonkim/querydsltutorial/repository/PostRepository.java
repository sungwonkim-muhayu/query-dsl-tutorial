package com.sungwonkim.querydsltutorial.repository;

import com.sungwonkim.querydsltutorial.model.entity.Post;
import com.sungwonkim.querydsltutorial.repository.custom.QueryDslPostRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository
    extends JpaRepository<Post, Long>, QuerydslPredicateExecutor<Post>, QueryDslPostRepository {}
