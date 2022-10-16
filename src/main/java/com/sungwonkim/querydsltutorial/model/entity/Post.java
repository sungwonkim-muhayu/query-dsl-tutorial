package com.sungwonkim.querydsltutorial.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @BatchSize(size = 5)
  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  private final Set<Comment> comments = new LinkedHashSet<>();

  @Setter
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Blog blog;

  public boolean addComment(final Comment comment) {
    comment.setPost(this);
    return this.comments.add(comment);
  }

  public boolean addComments(final Iterable<Comment> comments) {
    for (final Comment comment : comments) {
      this.addComment(comment);
    }
    return true;
  }
}
