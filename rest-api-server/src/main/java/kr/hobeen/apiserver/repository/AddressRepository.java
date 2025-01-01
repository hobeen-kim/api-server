package kr.hobeen.apiserver.repository;

import java.util.UUID;

import kr.hobeen.apiserver.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {
}

