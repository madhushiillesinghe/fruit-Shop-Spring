package lk.ijse.fruitshop.fruitshop.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class OrderDetailPrimaryKey implements Serializable {
    private String orderId;
    private String code;
}
