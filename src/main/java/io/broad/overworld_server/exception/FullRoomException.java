package io.broad.overworld_server.exception;

public class FullRoomException extends Exception {

  private String message;

  public FullRoomException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
