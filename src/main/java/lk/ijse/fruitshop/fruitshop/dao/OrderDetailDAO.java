package lk.ijse.fruitshop.fruitshop.dao;

import lk.ijse.fruitshop.fruitshop.entity.impl.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetailEntity, String> {
}
