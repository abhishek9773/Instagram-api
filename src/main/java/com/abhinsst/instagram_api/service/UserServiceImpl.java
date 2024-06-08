package com.abhinsst.instagram_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinsst.instagram_api.dto.UserDto;
import com.abhinsst.instagram_api.exception.UserException;
import com.abhinsst.instagram_api.model.User;
import com.abhinsst.instagram_api.repository.UserRepository;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User registerUser(User user) throws UserException {
    Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
    if (isEmailExist.isPresent()) {
      throw new UserException("Email is already exist");
    }
    Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
    if (isUsernameExist.isPresent()) {
      throw new UserException("Username is already exist");
    }

    if (user.getEmail() == null || user.getPassword() == null || user.getUsername() == null || user.getName() == null) {
      throw new UserException("all field are required");
    }

    User newUser = new User();
    newUser.setEmail(user.getEmail());
    newUser.setPassword(user.getPassword());
    newUser.setUsername(user.getUsername());
    newUser.setName(user.getName());

    return userRepository.save(newUser);
  }

  @Override
  public User findUserById(Integer userId) throws UserException {
    Optional<User> opt = userRepository.findById(userId);
    if (opt.isPresent()) {
      return opt.get();
    }
    throw new UserException("User not exist with id: " + userId);
  }

  @Override
  public User findUserProfile(String token) throws UserException {
    return null;
  }

  @Override
  public User findUserByUsername(String username) throws UserException {

    return null;
  }

  @Override
  public String followUser(Integer reqUserId, Integer followerUserId) throws UserException {

    User reqUser = findUserById(reqUserId);
    User followUser = findUserById(followerUserId);

    UserDto follower = new UserDto();
    follower.setEmail(reqUser.getEmail());
    follower.setId(reqUser.getId());
    follower.setName(reqUser.getName());
    follower.setUserImage(reqUser.getUserImage());
    follower.setUsername(reqUser.getUsername());

    UserDto following = new UserDto();
    following.setEmail(follower.getEmail());
    following.setId(follower.getId());
    following.setUserImage(follower.getUserImage());
    following.setName(follower.getName());
    following.setUsername(follower.getUsername());

    reqUser.getFollowing().add(following);
    followUser.getFollower().add(follower);

    userRepository.save(followUser);
    userRepository.save(reqUser);

    return "you are Following- " + followUser.getUsername();
  }

  @Override
  public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {

    User reqUser = findUserById(reqUserId);
    User followUser = findUserById(followUserId);

    UserDto follower = new UserDto();
    follower.setEmail(reqUser.getEmail());
    follower.setId(reqUser.getId());
    follower.setName(reqUser.getName());
    follower.setUserImage(reqUser.getUserImage());
    follower.setUsername(reqUser.getUsername());

    UserDto following = new UserDto();
    following.setEmail(follower.getEmail());
    following.setId(follower.getId());
    following.setUserImage(follower.getUserImage());
    following.setName(follower.getName());
    following.setUsername(follower.getUsername());

    reqUser.getFollowing().remove(following);
    followUser.getFollower().remove(follower);

    userRepository.save(followUser);
    userRepository.save(reqUser);

    return "You have unfollowed " + followUser.getUsername();
  }

  @Override
  public List<User> findUserByIds(List<Integer> userIds) throws UserException {

    List<User> users = userRepository.findAllUsersByUserIds(userIds);

    return users;
  }

  @Override
  public List<User> searchUser(String query) throws UserException {
    List<User> users = userRepository.findByQuery(query);
    if (users.size() == 0) {
      throw new UserException("user not found");
    }
    return users;

  }

  @Override
  public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
    if (updatedUser.getEmail() != null) {
      existingUser.setEmail(updatedUser.getEmail());
    }

    return null;
  }

}
