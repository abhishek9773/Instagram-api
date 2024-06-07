package com.abhinsst.instagram_api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.abhinsst.instagram_api.dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String username;
  private String email;
  private String mobile;
  private String website;
  private String bio;
  private String image;

  private String password;

  @Embedded
  @ElementCollection
  private Set<UserDto> follower = new HashSet<UserDto>();

  @Embedded
  @ElementCollection
  private Set<UserDto> following = new HashSet<UserDto>();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Story> stories = new ArrayList<>();

  @ManyToMany
  private List<Post> savePost = new ArrayList<>();

}
