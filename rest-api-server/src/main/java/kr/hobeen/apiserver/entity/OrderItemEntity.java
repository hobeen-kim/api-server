package kr.hobeen.apiserver.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_item")
@EqualsAndHashCode
@Getter
@Setter
public class OrderItemEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "order_id")
  private UUID orderId;

  @Column(name = "item_id")
  private UUID itemId;
}
