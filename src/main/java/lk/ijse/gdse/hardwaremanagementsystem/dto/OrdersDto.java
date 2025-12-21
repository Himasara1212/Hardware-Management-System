package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersDto {
    private String orderId;
    private String customerId;
    private LocalDateTime orderDate;
    private double totalAmount;
}