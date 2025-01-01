package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.AddressEntity;
import kr.hobeen.api.model.AddAddressReq;
import kr.hobeen.apiserver.repository.AddressRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository repository;

  public AddressServiceImpl(AddressRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq) {
    return Optional.of(repository.save(toEntity(addAddressReq)));
  }

  @Override
  public void deleteAddressesById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Optional<AddressEntity> getAddressesById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Iterable<AddressEntity> getAllAddresses() {
    return repository.findAll();
  }

  private AddressEntity toEntity(AddAddressReq model) {
    AddressEntity entity = new AddressEntity();

    entity.setNumber(model.getNumber());
    entity.setResidency(model.getResidency());
    entity.setStreet(model.getStreet());
    entity.setCity(model.getCity());
    entity.setState(model.getState());
    entity.setCountry(model.getCountry());
    entity.setPincode(model.getPincode());

    return entity;
  }
}
