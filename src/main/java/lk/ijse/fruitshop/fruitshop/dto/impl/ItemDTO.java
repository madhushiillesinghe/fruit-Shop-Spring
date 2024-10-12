package lk.ijse.fruitshop.fruitshop.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lk.ijse.fruitshop.fruitshop.customObj.ItemResponse;
import lk.ijse.fruitshop.fruitshop.dto.SuperDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDTO implements SuperDTO, ItemResponse {
    private String code;
    @NotBlank(message = "Description cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Description must contain only letters")
    private String description;
    private int quantity;
    private double price;
}
