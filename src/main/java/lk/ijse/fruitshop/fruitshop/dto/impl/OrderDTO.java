package lk.ijse.fruitshop.fruitshop.dto.impl;

import jakarta.validation.constraints.NotBlank;
import lk.ijse.fruitshop.fruitshop.dto.SuperDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDTO implements SuperDTO {
    private String orderId;
    private String date;
    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;
    private List<ItemDTO> itemDtoList;
    private double total;
    private String discount;
    private double subTotal;
    private double cash;
    private double balance;
}
