package lk.ijse.fruitshop.fruitshop.dao;

import lk.ijse.fruitshop.fruitshop.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {

}
