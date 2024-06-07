package com.abhinsst.instagram_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhinsst.instagram_api.exception.UserException;
import com.abhinsst.instagram_api.model.User;
import com.abhinsst.instagram_api.repository.UserRepository;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User registerUser(User user) throws UserException {
    userRepository.

    return null;
  }

  @Override
  public User findUserById(Integer userId) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
  }

  @Override
  public User findUserProfile(String token) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findUserProfile'");
  }

  @Override
  public User findUserByUsername(String username) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findUserByUsername'");
  }

  @Override
  public String followUser(Integer reqUserId, Integer followerUserId) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'followUser'");
  }

  @Override
  public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'unFollowUser'");
  }

  @Override
  public List<User> findUserByIds(List<Integer> userIds) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findUserByIds'");
  }

  @Override
  public List<User> searchUser(String query) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'searchUser'");
  }

  @Override
  public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateUserDetails'");
  }

}
