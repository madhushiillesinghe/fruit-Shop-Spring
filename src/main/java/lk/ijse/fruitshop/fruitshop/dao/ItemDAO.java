package lk.ijse.fruitshop.fruitshop.dao;

import lk.ijse.fruitshop.fruitshop.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity, String> {

}
