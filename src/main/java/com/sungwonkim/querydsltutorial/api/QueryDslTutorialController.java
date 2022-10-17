package com.sungwonkim.querydsltutorial.api;

import com.sungwonkim.querydsltutorial.model.entity.QPost;
import com.sungwonkim.querydsltutorial.service.BlogManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QueryDslTutorialController {
  private final BlogManagementService blogManagementService;

  @GetMapping("post")
  public void findPost() {
    blogManagementService.findAllPost();
  }

  @GetMapping("post/comments")
  public void findPostWithComments(
      @RequestParam(defaultValue = "3") final int limit,
      @RequestParam(defaultValue = "0") final int page) {

    final QPageRequest pageRequest = QPageRequest.of(page, limit, QSort.by(QPost.post.id.desc()));

    blogManagementService.findAllPostWithCommentsByPageRequest(pageRequest);
  }
}
