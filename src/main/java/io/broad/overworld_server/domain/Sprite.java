package io.broad.overworld_server.domain;

import lombok.Getter;

@Getter
public class Sprite {

  String currentAnimation;

  int currentAnimationFrame;

  int animationFrameProgress;

  @Override
  public String toString() {
    return "Sprite{" +
        "currentAnimation='" + currentAnimation + '\'' +
        ", currentAnimationFrame=" + currentAnimationFrame +
        ", animationFrameProgress=" + animationFrameProgress +
        '}';
  }
}
