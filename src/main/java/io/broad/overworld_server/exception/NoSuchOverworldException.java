package io.broad.overworld_server.exception;

public class NoSuchOverworldException extends Exception {

  private String message;

  public NoSuchOverworldException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
