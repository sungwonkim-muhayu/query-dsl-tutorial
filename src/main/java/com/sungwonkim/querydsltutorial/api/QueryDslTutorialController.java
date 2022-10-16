package com.sungwonkim.querydsltutorial.api;

import com.sungwonkim.querydsltutorial.service.BlogManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
  public void findPostWithComments() {
    blogManagementService.findAllPostWithComments();
  }
}
