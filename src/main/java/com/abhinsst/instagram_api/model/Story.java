package com.abhinsst.instagram_api.model;

import java.time.LocalDateTime;

import com.abhinsst.instagram_api.dto.UserDto;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "id", column = @Column(name = "user_id")),
      @AttributeOverride(name = "email", column = @Column(name = "user_email"))
  })
  private UserDto user;

  @NotNull
  private String image;
  private String captio;
  private LocalDateTime timeStamp;

}
