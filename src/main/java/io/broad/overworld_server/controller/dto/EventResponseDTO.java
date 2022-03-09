package io.broad.overworld_server.controller.dto;

import io.broad.overworld_server.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EventResponseDTO {

  private String type;

  private Player player;

  @Override
  public String toString() {
    return "EventResponseDTO{" +
        "type='" + type + '\'' +
        ", player=" + player +
        '}';
  }
}
