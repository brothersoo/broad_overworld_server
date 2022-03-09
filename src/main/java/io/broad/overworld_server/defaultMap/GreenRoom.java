package io.broad.overworld_server.defaultMap;

import io.broad.overworld_server.domain.GameObject;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GreenRoom {

  public final static String id = "GreenRoom";
  public final static String lowerSrc = "https://broad-overworld.s3.ap-northeast-2.amazonaws.com/maps/green_room.png";
  public final static String upperSrc = null;
  public final static Map<String, GameObject> gameObjects = new HashMap<>();
  public final static Map<String, String> walls = Stream.of(new String[][]{
      {asGridCoord(1, 0), "true"},
      {asGridCoord(2, 0), "true"},
      {asGridCoord(3, 0), "true"},
      {asGridCoord(4, 0), "true"},
      {asGridCoord(5, 0), "true"},
      {asGridCoord(6, 0), "true"},
      {asGridCoord(7, 0), "true"},
      {asGridCoord(8, 0), "true"},
      {asGridCoord(9, 0), "true"},
      {asGridCoord(10, 0), "true"},

      {asGridCoord(11, 1), "true"},
      {asGridCoord(11, 2), "true"},
      {asGridCoord(11, 3), "true"},
      {asGridCoord(11, 4), "true"},
      {asGridCoord(11, 5), "true"},
      {asGridCoord(11, 6), "true"},
      {asGridCoord(11, 7), "true"},
      {asGridCoord(11, 8), "true"},
      {asGridCoord(11, 9), "true"},
      {asGridCoord(11, 10), "true"},

      {asGridCoord(1, 11), "true"},
      {asGridCoord(2, 11), "true"},
      {asGridCoord(3, 11), "true"},
      {asGridCoord(4, 11), "true"},
      {asGridCoord(5, 11), "true"},
      {asGridCoord(6, 11), "true"},
      {asGridCoord(7, 11), "true"},
      {asGridCoord(8, 11), "true"},
      {asGridCoord(9, 11), "true"},
      {asGridCoord(10, 11), "true"},

      {asGridCoord(0, 1), "true"},
      {asGridCoord(0, 2), "true"},
      {asGridCoord(0, 3), "true"},
      {asGridCoord(0, 4), "true"},
      {asGridCoord(0, 5), "true"},
      {asGridCoord(0, 6), "true"},
      {asGridCoord(0, 7), "true"},
      {asGridCoord(0, 8), "true"},
      {asGridCoord(0, 9), "true"},
      {asGridCoord(0, 10), "true"},


  }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

  private static String asGridCoord(int x, int y) {
    return String.format("%d,%d", x * 16, y * 16);
  }
}
