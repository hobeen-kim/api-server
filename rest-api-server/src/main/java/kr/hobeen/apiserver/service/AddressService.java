package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.AddressEntity;
import kr.hobeen.api.model.AddAddressReq;
import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 */
public interface AddressService {
  Optional<AddressEntity> createAddress(AddAddressReq addAddressReq);

  void deleteAddressesById(String id);

  Optional<AddressEntity> getAddressesById(String id);

  Iterable<AddressEntity> getAllAddresses();
}
