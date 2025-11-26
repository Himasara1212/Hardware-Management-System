package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderItemDto {
    private int orderId;
    private int itemId;
    private int qty;
    private double unitPrice;
    private double total;

}
