package com.sungwonkim.querydsltutorial.repository;

import com.sungwonkim.querydsltutorial.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BlogRepository
    extends JpaRepository<Blog, Long>, QuerydslPredicateExecutor<Blog> {}
