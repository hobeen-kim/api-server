package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.AuthorizationEntity;
import kr.hobeen.api.model.PaymentReq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface PaymentService {

  Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);
  Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}