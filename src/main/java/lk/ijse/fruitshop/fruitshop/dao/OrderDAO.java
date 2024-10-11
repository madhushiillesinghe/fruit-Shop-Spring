package lk.ijse.fruitshop.fruitshop.dao;

import lk.ijse.fruitshop.fruitshop.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity, String> {
}
