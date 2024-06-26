package com.abhinsst.instagram_api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.abhinsst.instagram_api.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String caption;

  private String image;
  private String location;
  private LocalDateTime createdAt;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "id", column = @Column(name = "user_id")),
      @AttributeOverride(name = "email", column = @Column(name = "user_email"))
  })
  private UserDto user;
  @OneToMany
  private List<Comment> comments = new ArrayList<>();

  @Embedded
  @ElementCollection
  @JoinTable(name = "likedByUsers", joinColumns = @JoinColumn(name = "user_id"))
  private Set<UserDto> likedByUsers = new HashSet<>();

}
