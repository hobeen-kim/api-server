package kr.hobeen.apiserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "payment")
@EqualsAndHashCode
@Getter
@Setter
public class PaymentEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name="AUTHORIZED")
  private boolean authorized;

  @Column(name = "MESSAGE")
  private String message;

  @OneToOne(mappedBy = "paymentEntity")
  private OrderEntity orderEntity;
}
