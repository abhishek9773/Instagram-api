package com.abhinsst.instagram_api.model;

import java.util.HashSet;
import java.util.Set;

import com.abhinsst.instagram_api.dto.Userdto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

  private Set<Userdto> follower = new HashSet<Userdto>();

}
