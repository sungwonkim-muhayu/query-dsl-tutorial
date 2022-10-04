package com.sungwonkim.querydsltutorial.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  private final Set<Comment> comments = new LinkedHashSet<>();

  @Setter @ToString.Exclude @ManyToOne private Blog blog;

  public boolean addComment(final Comment comment) {
    comment.setPost(this);
    return this.comments.add(comment);
  }
}
