package kr.hobeen.apiserver.service;

import kr.hobeen.apiserver.entity.CardEntity;
import kr.hobeen.apiserver.entity.UserEntity;
import kr.hobeen.api.model.AddCardReq;
import kr.hobeen.apiserver.repository.CardRepository;
import kr.hobeen.apiserver.repository.UserRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Service
public class CardServiceImpl implements CardService {
  private final CardRepository repository;
  private final UserRepository userRepo;

  public CardServiceImpl(CardRepository repository, UserRepository userRepo) {
    this.repository = repository;
    this.userRepo = userRepo;
  }

  @Override
  public void deleteCardById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Iterable<CardEntity> getAllCards() {
    return repository.findAll();
  }

  @Override
  public Optional<CardEntity> getCardById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Optional<CardEntity> registerCard(@Valid AddCardReq addCardReq) {
    // add validation to make sure that only single card exists from one user
    // else it throws DataIntegrityViolationException for user_id (unique)
    return Optional.of(repository.save(toEntity(addCardReq)));
  }

  private CardEntity toEntity(AddCardReq m) {
    CardEntity e = new CardEntity();
    Optional<UserEntity> user = userRepo.findById(UUID.fromString(m.getUserId()));
    user.ifPresent(e::setUser);

    e.setNumber(m.getCardNumber());
    e.setCvv(m.getCvv());
    e.setExpires(m.getExpires());

    return e;
  }
}
