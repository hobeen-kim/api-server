package kr.hobeen.apiserver.service;

import static java.util.stream.Collectors.toList;

import kr.hobeen.apiserver.entity.ItemEntity;
import kr.hobeen.apiserver.entity.ProductEntity;
import kr.hobeen.api.model.Item;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 */
@Service
public class ItemServiceImpl implements ItemService {

  @Override
  public ItemEntity toEntity(Item m) {
    ItemEntity e = new ItemEntity();

    ProductEntity product = new ProductEntity();
    product.setId(UUID.fromString(m.getId()));
    e.setProduct(product);
    e.setPrice(m.getUnitPrice());
    e.setQuantity(m.getQuantity());
    return e;
  }

  @Override
  public List<ItemEntity> toEntityList(List<Item> items) {
    if (Objects.isNull(items)) {
      return List.of();
    }
    return items.stream().map(this::toEntity).collect(toList());
  }

  @Override
  public Item toModel(ItemEntity e) {
    Item m = new Item();
    m.id(e.getProduct().getId().toString()).unitPrice(e.getPrice()).quantity(e.getQuantity());
    return m;
  }

  @Override
  public List<Item> toModelList(List<ItemEntity> items) {
    if (Objects.isNull(items)) {
      return List.of();
    }
    return items.stream().map(this::toModel).collect(toList());
  }
}
