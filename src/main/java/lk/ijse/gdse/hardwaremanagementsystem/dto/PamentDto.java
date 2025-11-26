package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class PamentDto {
    private String paymentId;
    private String orderId;
    private LocalDateTime paymentDate;
    private String method;
    private double amount;
    private String status;
}
