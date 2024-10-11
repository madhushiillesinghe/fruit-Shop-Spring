package lk.ijse.fruitshop.fruitshop.service;

import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderService extends SuperService{
    void saveOrder(OrderDTO orderDto);
    List<OrderDTO> getAllOrder();

}
