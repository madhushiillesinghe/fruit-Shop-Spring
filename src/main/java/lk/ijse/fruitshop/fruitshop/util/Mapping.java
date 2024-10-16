package lk.ijse.fruitshop.fruitshop.util;


import lk.ijse.fruitshop.fruitshop.dto.impl.CustomerDTO;
import lk.ijse.fruitshop.fruitshop.dto.impl.ItemDTO;
import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDTO;
import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDetailDTO;
import lk.ijse.fruitshop.fruitshop.entity.impl.CustomerEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.ItemEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.OrderDetailEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

//    customer mapping
    public CustomerDTO convertToCustomerDTO(CustomerEntity customer){return modelMapper.map(customer, CustomerDTO.class);}
    public CustomerEntity convertToCustomerEntity(CustomerDTO dto) {return modelMapper.map(dto, CustomerEntity.class);}
    public List<CustomerDTO> convertToCustomerDTO(List<CustomerEntity> customer){return modelMapper.map(customer,new TypeToken<List<CustomerDTO>>() {}.getType());}


//    item mapping
    public ItemDTO convertToItemDTO(ItemEntity item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public ItemEntity convertToItemEntity(ItemDTO dto) {
        return modelMapper.map(dto, ItemEntity.class);
    }
    public List<ItemDTO> convertToItemDTO(List<ItemEntity> items){return modelMapper.map(items,new TypeToken<List<ItemDTO>>() {}.getType());}

//    order mapping
    public OrderEntity convertToOrderEntity(OrderDTO dto) {
        return modelMapper.map(dto, OrderEntity.class);}
    public List<OrderDTO> convertToOrderDTO(List<OrderEntity> ordersEntity){return modelMapper.map(ordersEntity,new TypeToken<List<OrderDTO>>() {}.getType());}

//    order detail  mapping
    public OrderDetailEntity convertToOrderDetailEntity(OrderDetailDTO dto) {return modelMapper.map(dto, OrderDetailEntity.class);}

}
