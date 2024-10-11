package lk.ijse.fruitshop.fruitshop.service.impl;

import lk.ijse.fruitshop.fruitshop.dao.ItemDAO;
import lk.ijse.fruitshop.fruitshop.dao.OrderDAO;
import lk.ijse.fruitshop.fruitshop.dao.OrderDetailDAO;
import lk.ijse.fruitshop.fruitshop.dto.impl.ItemDTO;
import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDTO;
import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDetailDTO;
import lk.ijse.fruitshop.fruitshop.embedded.OrderDetailPrimaryKey;
import lk.ijse.fruitshop.fruitshop.entity.impl.ItemEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.OrderDetailEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.OrderEntity;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.service.PlaceOrderService;
import lk.ijse.fruitshop.fruitshop.util.AppUtil;
import lk.ijse.fruitshop.fruitshop.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaceOrderServiceIMPL implements PlaceOrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderDetailDAO orderDetailDAO;
    @Autowired
    private  ItemDAO itemDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveOrder(OrderDTO orderDto) {
        orderDto.setOrderId(AppUtil.createOrderId());
        OrderEntity orderEntity = mapping.convertToOrderEntity(orderDto);
        OrderEntity orderSave=orderDAO.save(orderEntity);
        if (orderSave == null && orderSave.getOrderId() == null) {
            throw new DataPersistFailedException("Can not place the order");
        }else {
            for (ItemDTO itemDTO:orderDto.getItemDtoList()){
                Optional<ItemEntity> item=itemDAO.findById((itemDTO.getCode()));

                OrderDetailDTO orderDetailDTO=new OrderDetailDTO();
                orderDetailDTO.setOrderId(orderDto.getOrderId());
                orderDetailDTO.setOrder_qty(itemDTO.getQuantity());
                orderDetailDTO.setUnitPrice(itemDTO.getPrice());
                orderDetailDTO.setItemCode(itemDTO.getCode());

                OrderDetailPrimaryKey orderDetailPrimaryKey=new OrderDetailPrimaryKey(orderDto.getOrderId(),itemDTO.getCode());
                OrderDetailEntity orderDetailEntity = mapping.convertToOrderDetailEntity(orderDetailDTO);
                orderDetailEntity.setOrderDetailPrimaryKey(orderDetailPrimaryKey);



                OrderDetailEntity saveOrderDetail=orderDetailDAO.save(orderDetailEntity);
                if (saveOrderDetail == null && saveOrderDetail.getOrder().getOrderId() == null) {
                    throw new DataPersistFailedException();
            }else {
                        ItemEntity itemEntity=mapping.convertToItemEntity(itemDTO);
                        itemEntity.setQuantity((item.get().getQuantity())-itemDTO.getQuantity());
                        itemDAO.save(itemEntity);
                }
        }
        }
    }
    @Override
    public List<OrderDTO> getAllOrder() {
        List<OrderDTO> orderDTOS = mapping.convertToOrderDTO(orderDAO.findAll());
        return orderDTOS;

    }
}
