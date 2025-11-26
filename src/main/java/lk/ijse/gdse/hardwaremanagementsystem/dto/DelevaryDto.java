package lk.ijse.gdse.hardwaremanagementsystem.dto;

import java.time.LocalDateTime;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class DelevaryDto {
    private String deliveryId;
    private String orderId;
    private LocalDateTime deliveryDate;
    private double deliveryCharge;
    private String reason;
    private String status;

}
