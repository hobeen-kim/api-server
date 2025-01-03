package kr.hobeen.apiserver.controller;

import kr.hobeen.api.ShipmentApi;
import kr.hobeen.apiserver.hateoas.ShipmentRepresentationModelAssembler;
import kr.hobeen.api.model.Shipment;
import kr.hobeen.apiserver.service.ShipmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@RestController
public class ShipmentController implements ShipmentApi {

  private final ShipmentService service;
  private final ShipmentRepresentationModelAssembler assembler;

  public ShipmentController(ShipmentService service, ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<List<Shipment>> getShipmentByOrderId(@NotNull @Valid String id) {
    return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
  }
}
