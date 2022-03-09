package io.broad.overworld_server.service;

import io.broad.overworld_server.controller.dto.PlayersDTO;
import io.broad.overworld_server.domain.Overworld;
import io.broad.overworld_server.domain.Player;
import io.broad.overworld_server.exception.AlreadyExistingOverworldException;
import io.broad.overworld_server.exception.FullRoomException;
import io.broad.overworld_server.exception.NoSuchOverworldException;
import io.broad.overworld_server.repository.OverworldRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OverworldService {

  private final OverworldRepository overworldRepository;

  public Overworld createOverworld(String overworldId) throws AlreadyExistingOverworldException {
    // TODO: maxParticipant Num
    Optional<Overworld> overworld = overworldRepository.findById(overworldId);
    if (overworld.isPresent()) {
      throw new AlreadyExistingOverworldException("Already existing overworld id " + overworldId);
    } else {
      Overworld newOverworld = new Overworld(overworldId, 5);
      overworldRepository.save(newOverworld);

      return newOverworld;
    }
  }

  public void connectToOverworld(Player newPlayer, String overworldId)
      throws FullRoomException, NoSuchOverworldException {
    Optional<Overworld> overworld = overworldRepository.findById(overworldId);

    if (overworld.isPresent()) {
      if (overworld.get().isFull()) {
        throw new FullRoomException("There is no more space for this overworld!");
      }

      // TODO: validate userName duplication
      overworld.get().addPlayer(newPlayer);
      overworldRepository.save(overworld.get());
    } else {
      throw new NoSuchOverworldException("No such overworld " + overworldId);
    }
  }

  public void disconnectFromOverworld(Player player, String overworldId) {
    Optional<Overworld> overworld = overworldRepository.findById(overworldId);

    overworld.ifPresent(value -> value.removePlayer(player));
  }

  public PlayersDTO getPlayers(String overworldId) {
    Optional<Overworld> overworld = overworldRepository.findById(overworldId);
    return new PlayersDTO(overworld.get().getPlayers());
  }

  public Optional<Overworld> updatePlayerStatus(Player player, String overworldId) {
    Optional<Overworld> overworld = overworldRepository.findById(overworldId);
    Player targetPlayer = overworld.get().getPlayer(player.getId());
    targetPlayer.update(player);
    overworldRepository.save(overworld.get());
    return overworld;
  }
}
