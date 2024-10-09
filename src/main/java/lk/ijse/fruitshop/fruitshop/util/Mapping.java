package lk.ijse.fruitshop.fruitshop.util;


import lk.ijse.fruitshop.fruitshop.dto.NoteDto;
import lk.ijse.fruitshop.fruitshop.dto.UserDTO;
import lk.ijse.fruitshop.fruitshop.entity.NoteEntity;
import lk.ijse.fruitshop.fruitshop.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //    mapping
    //    note detail
    public NoteDto convertToDTO(NoteEntity note){
        return modelMapper.map(note, NoteDto.class);
    }
    public NoteEntity convertToEntity(NoteDto dto) {
        System.out.println(dto + " At Mapper");
        return modelMapper.map(dto, NoteEntity.class);
    }
    public List<NoteDto> convertToDTO(List<NoteEntity> notes){
        return modelMapper.map(notes,new TypeToken<List<NoteDto>>() {}.getType());
    }
    //user mapping
    public UserDTO convertToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public UserEntity convertToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> convertToUserDTO(List<UserEntity> users ){
        return modelMapper.map(users,new TypeToken<List<UserDTO>>() {}.getType());
    }

}
