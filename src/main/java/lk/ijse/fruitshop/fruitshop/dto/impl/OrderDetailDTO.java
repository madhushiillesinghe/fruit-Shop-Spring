package lk.ijse.fruitshop.fruitshop.dto.impl;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lk.ijse.fruitshop.fruitshop.dto.SuperDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OrderDetailDTO implements SuperDTO {
    private String orderId;
    @Min(value = 1, message = "Quantity must be at least 1")
    private  int order_qty;
    @NotBlank(message = "Item code cannot be blank")
    private String itemCode;
    @Positive(message = "Unit price must be greater than zero")
    private double unitPrice;
}
