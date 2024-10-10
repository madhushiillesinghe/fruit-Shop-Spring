package lk.ijse.fruitshop.fruitshop.customObj.impl;

import lk.ijse.fruitshop.fruitshop.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderErrorResponse implements OrderResponse, Serializable {
    private int errorcode;
    private String errormessage;
}
