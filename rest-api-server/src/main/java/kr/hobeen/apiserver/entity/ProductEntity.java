package kr.hobeen.apiserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
@EqualsAndHashCode
@Getter
@Setter
public class ProductEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @NotNull(message = "Product name is required.")
  @Basic(optional = false)
  @Column(name = "NAME")
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "PRICE")
  private BigDecimal price;

  @Column(name = "COUNT")
  private int count;

  @Column(name = "IMAGE_URL")
  private String imageUrl;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "PRODUCT_TAG",
      joinColumns = @JoinColumn(name = "PRODUCT_ID"),
      inverseJoinColumns = @JoinColumn(name = "TAG_ID")
  )
  private List<TagEntity> tags = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  private List<ItemEntity> items;

  public ProductEntity(UUID id, @NotNull(message = "Product name is required.") String name,
      String description, BigDecimal price, int count, String imageUrl) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.count = count;
    this.imageUrl = imageUrl;
  }

  public ProductEntity() {
  }
}