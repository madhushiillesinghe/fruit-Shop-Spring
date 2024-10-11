package lk.ijse.fruitshop.fruitshop.entity.impl;

import jakarta.persistence.*;
import lk.ijse.fruitshop.fruitshop.embedded.OrderDetailPrimaryKey;
import lk.ijse.fruitshop.fruitshop.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity implements SuperEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",
            insertable = false,
            updatable = false)
    private OrderEntity order;
    private  int order_qty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code",referencedColumnName = "code",
            insertable = false,
            updatable = false)
    private ItemEntity item;
    private double unitPrice;
    @EmbeddedId
    private OrderDetailPrimaryKey orderDetailPrimaryKey;

}
