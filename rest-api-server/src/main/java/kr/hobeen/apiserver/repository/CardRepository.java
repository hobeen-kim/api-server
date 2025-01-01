package kr.hobeen.apiserver.repository;

import java.util.UUID;

import kr.hobeen.apiserver.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<CardEntity, UUID> {
}

