package lk.ijse.fruitshop.fruitshop.service;

import jakarta.transaction.Transactional;

import lk.ijse.fruitshop.fruitshop.customObj.UserErrorResponse;
import lk.ijse.fruitshop.fruitshop.customObj.UserResponse;
import lk.ijse.fruitshop.fruitshop.dao.UserDao;
import lk.ijse.fruitshop.fruitshop.dto.UserDTO;
import lk.ijse.fruitshop.fruitshop.entity.UserEntity;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.exception.ItemNotFoundException;
import lk.ijse.fruitshop.fruitshop.util.AppUtil;
import lk.ijse.fruitshop.fruitshop.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity usersave= userDao.save(mapping.convertToUserEntity(userDTO));
        if(usersave == null && usersave.getUserId() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }    }
    @Override
    public  void updateUser( UserDTO userDTO) {
        //controlling the null point exception
        Optional<UserEntity> updateById=userDao.findById(userDTO.getUserId());
        if(!updateById.isPresent()){
            throw new ItemNotFoundException("User not found");
        }else {
            updateById.get().setEmail(userDTO.getEmail());
            updateById.get().setPassword(userDTO.getPassword());
            updateById.get().setFirstName(userDTO.getFirstName());
            updateById.get().setLastName(userDTO.getLastName());
            updateById.get().setProfilepic(userDTO.getProfilepic());

        }    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUserId = userDao.findById(userId);
        if(selectedUserId.isPresent()){
            userDao.deleteById(userId);
        }else {
            throw new ItemNotFoundException("User not found");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return  mapping.convertToUserDTO(userDao.findAll());
    }
// get user by id using same for note
    @Override
    public UserDTO getSelectUser(String userId) {
        return mapping.convertToUserDTO(userDao.getReferenceById(userId));
    }
    @Override
    public UserResponse getSelectUserBYId(String userId) {
        if(userDao.existsById(userId)){
            UserEntity userEntityByUserId = userDao.getUserEntitiesByUserId(userId);
            return mapping.convertToUserDTO(userEntityByUserId);
        }else {
            return new UserErrorResponse(0, "User not found");
        }
    }
}
