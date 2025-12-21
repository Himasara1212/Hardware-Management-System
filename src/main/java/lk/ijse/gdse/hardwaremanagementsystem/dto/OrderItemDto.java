package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDto {
    private String orderItemId;
    private String orderId;
    private String itemId;
    private int qty;
    private double unitPrice;
    private double total;
}
