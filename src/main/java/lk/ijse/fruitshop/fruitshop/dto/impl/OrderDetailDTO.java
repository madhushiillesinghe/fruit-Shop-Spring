package lk.ijse.fruitshop.fruitshop.dto.impl;

import lk.ijse.fruitshop.fruitshop.dto.SuperDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OrderDetailDTO implements SuperDTO {
    private String orderId;
    private  int order_qty;
    private String itemCode;
    private double unitPrice;
}
