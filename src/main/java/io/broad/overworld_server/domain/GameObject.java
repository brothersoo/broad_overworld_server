package io.broad.overworld_server.domain;

import java.util.Arrays;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "gameObject")
@Getter
public class GameObject {

  @Id
  private String id;

  private boolean isMounted;

  private int x;

  private int y;

  private Direction direction;

  private Sprite sprite;

  private int[] behaviorLoop;

  private int behaviorLoopIndex;

  private int[] talking;

  public void update(GameObject newInfo) {
    x = newInfo.getX();
    y = newInfo.getY();
    direction = newInfo.getDirection();
    behaviorLoop = newInfo.getBehaviorLoop();
    behaviorLoopIndex = newInfo.getBehaviorLoopIndex();
    talking = newInfo.getTalking();
  }

  @Override
  public String toString() {
    return "GameObject{" +
        "id='" + id + '\'' +
        ", isMounted=" + isMounted +
        ", x=" + x +
        ", y=" + y +
        ", direction=" + direction +
        ", sprite=" + sprite +
        ", behaviorLoop=" + Arrays.toString(behaviorLoop) +
        ", behaviorLoopIndex=" + behaviorLoopIndex +
        ", talking=" + Arrays.toString(talking) +
        '}';
  }
}
