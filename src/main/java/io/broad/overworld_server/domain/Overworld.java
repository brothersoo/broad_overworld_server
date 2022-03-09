package io.broad.overworld_server.domain;

import static io.broad.overworld_server.domain.OverworldStatus.IN_PROGRESS;

import io.broad.overworld_server.defaultMap.GreenRoom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "overworld")
@Getter
@NoArgsConstructor
public class Overworld {

  @Id
  private String id;
  private Map<String, GameObject> gameObjects;
  private Map<String, Player> players;
  private OverworldStatus status;
  private int maxParticipantNum;
  private String lowerSrc;
  private String upperSrc;
  private Map<String, Boolean> walls;

  public Overworld(int maxParticipantNum) {
    id = UUID.randomUUID().toString();
    gameObjects = new HashMap<>();
    players = new HashMap<>();
    status = IN_PROGRESS;
    this.maxParticipantNum = maxParticipantNum;
    this.lowerSrc = GreenRoom.lowerSrc;
  }

  public Overworld(String id, int maxParticipantNum) {
    this(maxParticipantNum);
    this.id = id;
  }

  public Overworld(int maxParticipantNum, String lowerSrc, String upperSrc,
      Map<String, Boolean> walls) {
    this(maxParticipantNum);
    this.lowerSrc = lowerSrc;
    this.upperSrc = upperSrc;
    this.walls = walls;
  }

  public Player getPlayer(String playerId) {
    return players.getOrDefault(playerId, null);
  }

  public void addPlayer(Player player) {
    if (players == null) {
      players = new HashMap<>();
    }
    players.put(player.getId(), player);
  }

  public void removePlayer(Player player) {
    players.remove(player);
  }

  public void changeStatus(Overworld Status) {
    status = status;
  }

  private String asGridCoord(int x, int y) {
    return x * 16 + "," + y * 16;
  }

  public boolean isFull() {
    return players != null && players.size() == maxParticipantNum;
  }
}
