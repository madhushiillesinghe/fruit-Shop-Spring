package lk.ijse.fruitshop.fruitshop.dto.impl;

import lk.ijse.fruitshop.fruitshop.customObj.ItemResponse;
import lk.ijse.fruitshop.fruitshop.dto.SuperDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDTO implements SuperDTO, ItemResponse {
    private String code;
    private String description;
    private int quantity;
    private double price;
}
