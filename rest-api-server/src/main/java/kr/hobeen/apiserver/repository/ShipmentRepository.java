package kr.hobeen.apiserver.repository;

import kr.hobeen.apiserver.entity.ShipmentEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface ShipmentRepository extends CrudRepository<ShipmentEntity, UUID> {
}

