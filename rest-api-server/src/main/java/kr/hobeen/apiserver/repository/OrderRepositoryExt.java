package kr.hobeen.apiserver.repository;

import kr.hobeen.api.model.NewOrder;
import kr.hobeen.apiserver.entity.OrderEntity;
import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface OrderRepositoryExt {
  Optional<OrderEntity> insert(NewOrder m);
}

