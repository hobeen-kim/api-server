package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.AuthorizationEntity;
import kr.hobeen.apiserver.entity.OrderEntity;
import kr.hobeen.api.model.PaymentReq;
import kr.hobeen.apiserver.repository.OrderRepository;
import kr.hobeen.apiserver.repository.PaymentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository repository;
  private final OrderRepository orderRepo;

  public PaymentServiceImpl(PaymentRepository repository, OrderRepository orderRepo) {
    this.repository = repository;
    this.orderRepo = orderRepo;
  }

  @Override
  public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq) {
    return Optional.empty();
  }

  @Override
  public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId) {
    return orderRepo.findById(UUID.fromString(orderId)).map(OrderEntity::getAuthorizationEntity);
  }

  /*private AuthorizationEntity toEntity(PaymentReq m) {
    PaymentEntity e = new PaymentEntity();
    e.setAuthorized(true).setMessage()
  }*/
}
