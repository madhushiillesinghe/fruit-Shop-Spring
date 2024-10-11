package lk.ijse.fruitshop.fruitshop.service;

import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDTO;
import java.util.List;

public interface PlaceOrderService {
    void saveOrder(OrderDTO orderDto);
    List<OrderDTO> getAllOrder();

}
