package com.sungwonkim.querydsltutorial.repository;

import com.sungwonkim.querydsltutorial.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CommentRepository
    extends JpaRepository<Comment, Long>, QuerydslPredicateExecutor<Comment> {}
