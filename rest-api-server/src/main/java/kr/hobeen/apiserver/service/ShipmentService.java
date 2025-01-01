package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.ShipmentEntity;
import jakarta.validation.constraints.Min;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface ShipmentService {
  Iterable<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
