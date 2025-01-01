package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.AddressEntity;
import kr.hobeen.apiserver.entity.CardEntity;
import kr.hobeen.apiserver.entity.UserEntity;
import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface UserService {
  void deleteCustomerById(String id);
  Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
  Iterable<UserEntity> getAllCustomers();
  Optional<CardEntity> getCardByCustomerId(String id);
  Optional<UserEntity> getCustomerById(String id);
}
