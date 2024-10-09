package lk.ijse.fruitshop.fruitshop.dao;

import lk.ijse.fruitshop.fruitshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {

    UserEntity getUserEntitiesByUserId(String userId);
}
