package kr.hobeen.apiserver.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "\"authorization\"")
@EqualsAndHashCode
@Getter
@Setter
public class AuthorizationEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name="AUTHORIZED")
  private boolean authorized;

  @Column(name="TIME")
  private Timestamp time;

  @Column(name = "MESSAGE")
  private String message;

  @Column(name = "ERROR")
  private String error;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ORDER_ID", referencedColumnName = "id")
  private OrderEntity orderEntity;
}
