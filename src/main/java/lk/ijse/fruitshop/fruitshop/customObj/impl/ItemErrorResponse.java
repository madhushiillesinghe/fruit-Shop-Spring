package lk.ijse.fruitshop.fruitshop.customObj.impl;

import lk.ijse.fruitshop.fruitshop.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemErrorResponse implements ItemResponse, Serializable {
    private int errorcode;
    private String errormessage;
}
