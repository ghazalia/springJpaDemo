package com.example.novelreview.exception;

public class DataAlreadyExistException extends RuntimeException {

  public DataAlreadyExistException() {
  }

  public DataAlreadyExistException(String message) {
    super(message);
  }

}
