package com.abhinsst.instagram_api.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.abhinsst.instagram_api.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "id", column = @Column(name = "user_id")),
      @AttributeOverride(name = "email", column = @Column(name = "user_email"))
  })
  private UserDto user;

  private String content;

  @Embedded
  @ElementCollection
  private Set<UserDto> likeByUsers = new HashSet<UserDto>();

  private LocalDateTime createdAt;

}
