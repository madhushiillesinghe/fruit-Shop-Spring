package lk.ijse.fruitshop.fruitshop.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lk.ijse.fruitshop.fruitshop.customObj.CustomerResponse;
import lk.ijse.fruitshop.fruitshop.dto.SuperDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerResponse {
    private String id;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "First name must contain only alphabets and be 2-30 characters long")
    private String  name;
    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address;
    private double salary;
}
