package io.broad.overworld_server.exception;

public class AlreadyExistingOverworldException extends Exception {

  private String message;

  public AlreadyExistingOverworldException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
