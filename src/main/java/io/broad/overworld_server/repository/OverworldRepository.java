package io.broad.overworld_server.repository;

import io.broad.overworld_server.domain.Overworld;
import org.springframework.data.repository.CrudRepository;

public interface OverworldRepository extends CrudRepository<Overworld, String> {

}
