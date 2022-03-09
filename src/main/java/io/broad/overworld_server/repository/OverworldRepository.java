package io.broad.overworld_server.repository;

import io.broad.overworld_server.domain.Overworld;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OverworldRepository extends CrudRepository<Overworld, String> {


//  private static Map<String, Overworld> overworlds;
//
//  @Value("${room.demo}")
//  private static String demoRoomId;
//
//  public OverworldRepository() {
//    overworlds = new HashMap<>();
//    overworlds.put(demoRoomId, new Overworld(5));
//  }
//
//  public Map<String, Overworld> getOverworlds() {
//    return overworlds;
//  }
//
//  public Overworld getOverworld(String overworldId) {
//    return overworlds.getOrDefault(overworldId, null);
//  }
//
//  public void addOverworld(Overworld overworld) {
//    overworlds.put(overworld.getId(), overworld);
//  }
}
