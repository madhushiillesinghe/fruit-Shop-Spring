package lk.ijse.fruitshop.fruitshop.service;



import lk.ijse.fruitshop.fruitshop.customObj.UserResponse;
import lk.ijse.fruitshop.fruitshop.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    List<UserDTO> getAllUsers();
    UserResponse getSelectUserBYId(String userId);
    UserDTO getSelectUser(String userId);
}
