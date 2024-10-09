package lk.ijse.fruitshop.fruitshop.customObj.impl;

import lk.ijse.fruitshop.fruitshop.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerErrorResponse implements CustomerResponse, Serializable {
    private int errorcode;
    private String errormessage;
}
