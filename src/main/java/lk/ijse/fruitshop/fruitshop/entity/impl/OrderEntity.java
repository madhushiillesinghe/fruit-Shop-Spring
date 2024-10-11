package lk.ijse.fruitshop.fruitshop.entity.impl;

import jakarta.persistence.*;
import lk.ijse.fruitshop.fruitshop.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="customer_id",nullable = false )
    private CustomerEntity customer;
    private double total;
    private String discount;
    private double sub_total;
    private double cash;
    private double balance;
    @OneToMany(mappedBy = "order")
    private List<OrderDetailEntity> orderdetail;
}
