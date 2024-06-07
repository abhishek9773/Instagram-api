package com.abhinsst.instagram_api.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

  private String message;
  private String details;
  private LocalDateTime timeStamp;

}
