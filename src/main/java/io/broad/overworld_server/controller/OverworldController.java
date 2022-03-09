package io.broad.overworld_server.controller;

import io.broad.overworld_server.controller.dto.EventResponseDTO;
import io.broad.overworld_server.controller.dto.OverworldCreateDTO;
import io.broad.overworld_server.controller.dto.PlayersDTO;
import io.broad.overworld_server.domain.Overworld;
import io.broad.overworld_server.domain.Player;
import io.broad.overworld_server.exception.AlreadyExistingOverworldException;
import io.broad.overworld_server.exception.FullRoomException;
import io.broad.overworld_server.exception.NoSuchOverworldException;
import io.broad.overworld_server.service.OverworldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
//@RequestMapping("/overworld")
public class OverworldController {

  private final OverworldService overworldService;
  private final SimpMessagingTemplate simpMessagingTemplate;

  @PostMapping("/overworld")
  public ResponseEntity<Overworld> createOverworld(@RequestBody OverworldCreateDTO overworldCreateDTO)
      throws AlreadyExistingOverworldException {
    log.info("Create new Overworld: {}", overworldCreateDTO.getOverworldId());

    Overworld overworld = overworldService.createOverworld(overworldCreateDTO.getOverworldId());

    return ResponseEntity
        .ok()
        .body(overworld);
  }

  @MessageMapping("/newPlayer/{overworldId}")
  public void newPlayer(@DestinationVariable("overworldId") String overworldId, Player player)
      throws FullRoomException, NoSuchOverworldException {
    log.info("NEW PLAYER: {}", player);

    overworldService.connectToOverworld(player, overworldId);

    EventResponseDTO response = new EventResponseDTO("NEW_PLAYER", player);

    log.info("NEW PLAYER DATA SENT {}", response);

    simpMessagingTemplate.convertAndSend("/topic/overworld_progress/" + overworldId, response);
  }

  @GetMapping("/players/{overworldId}")
  public ResponseEntity<PlayersDTO> getPlayers(@PathVariable("overworldId") String overworldId) {
    log.info("Requested players of {}", overworldId);

    return ResponseEntity
        .ok()
        .body(overworldService.getPlayers(overworldId));
  }

  @MessageMapping("/action/{overworldId}")
  public void action(@DestinationVariable("overworldId") String overworldId, Player player) {
    log.info("ACTION: {}", player);

    overworldService.updatePlayerStatus(player, overworldId);

    EventResponseDTO response = new EventResponseDTO("ACTION", player);

    simpMessagingTemplate.convertAndSend("/topic/overworld_progress/" + overworldId, response);
  }
}
