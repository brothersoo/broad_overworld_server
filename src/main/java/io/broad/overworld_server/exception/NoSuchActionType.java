package io.broad.overworld_server.exception;

public class NoSuchActionType extends Exception {

  private String message;

  public NoSuchActionType(String message) {
    super(message);
  }

  public String getMessage() {
    return message;
  }

}
