package io.broad.overworld_server.controller.dto;

import io.broad.overworld_server.domain.Player;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayersDTO {

  Map<String, Player> players;
}
