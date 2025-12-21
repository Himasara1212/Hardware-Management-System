package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ReturnDto {
    private String returnId;
    private String orderId;
    private LocalDateTime returnDate;
    private double refundAmount;
    private String reason;
    private String status;
}
