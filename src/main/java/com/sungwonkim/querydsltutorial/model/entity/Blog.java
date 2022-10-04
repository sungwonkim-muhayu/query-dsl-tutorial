package com.sungwonkim.querydsltutorial.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Blog {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)
  private final Set<Post> posts = new LinkedHashSet<>();

  public boolean addPost(final Post post) {
    post.setBlog(this);
    return this.posts.add(post);
  }
}
