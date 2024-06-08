package com.abhinsst.instagram_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhinsst.instagram_api.exception.UserException;
import com.abhinsst.instagram_api.model.User;
import com.abhinsst.instagram_api.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/signin")
  public ResponseEntity<User> registerUser(User user) throws UserException {
    User newUser = userService.registerUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @GetMapping("/user/userId")
  public ResponseEntity<User> findUserById(@PathVariable Integer userId) throws UserException {
    User user = userService.findUserById(userId);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  public User findUserProfile(String token) throws UserException {
    return null;
  }

  @GetMapping("/user/username")
  public ResponseEntity<User> findUserByUsername(@PathVariable String username) throws UserException {
    User user = userService.findUserByUsername(username);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  public String followUser(Integer reqUserId, Integer followerUserId) throws UserException {
    return null;
  }

  public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
    return null;
  }

  public List<User> findUserByIds(List<Integer> userIds) throws UserException {
    return null;
  }

  public List<User> searchUser(String query) throws UserException {
    return null;
  }

  public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
    return null;
  }

}
