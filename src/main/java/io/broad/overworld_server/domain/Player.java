package io.broad.overworld_server.domain;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "player")
@Getter
public class Player extends GameObject {

  private int movingProgressRemaining;

  private Boolean isStanding;

  public void update(Player newStatus) {
    super.update(newStatus);
    movingProgressRemaining = newStatus.getMovingProgressRemaining();
    isStanding = newStatus.getIsStanding();
  }

  @Override
  public String toString() {
    return super.toString() + "Player{" +
        "movingProgressRemaining=" + movingProgressRemaining +
        ", isStanding=" + isStanding +
        '}';
  }
}
