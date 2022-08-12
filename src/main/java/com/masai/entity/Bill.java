package com.masai.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class Bill {
    private  String billed;
    private LocalDateTime billDate;
    private OrderDetails order;

    public Bill(String billed, LocalDateTime billDate, OrderDetails order) {
        this.billed = billed;
        this.billDate = billDate;
        this.order = order;
    }

    public String getBilled() {
        return billed;
    }

    public void setBilled(String billed) {
        this.billed = billed;
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
                "billed='" + billed + '\'' +
                ", billDate=" + billDate +
                ", order=" + order +
                '}';
    }
}
