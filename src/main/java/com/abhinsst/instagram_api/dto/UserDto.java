package com.abhinsst.instagram_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {

  private Integer id;
  private String username;
  private String email;
  private String name;
  private String userImage;

}
