package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
@Entity
public class Bill {
    @Id
    private  String billId;
    private LocalDateTime billDate;
    @OneToOne
    private OrderDetails order;

    public Bill(String billed, LocalDateTime billDate, OrderDetails order) {
        this.billId = billed;
        this.billDate = billDate;
        this.order = order;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public OrderDetails getOrder() {
        return order;
    }

    public void setOrder(OrderDetails order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", billDate=" + billDate +
                ", order=" + order +
                '}';
    }
}
