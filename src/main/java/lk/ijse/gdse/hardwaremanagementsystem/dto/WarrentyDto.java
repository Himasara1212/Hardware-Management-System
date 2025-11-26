package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class WarrentyDto {
    private String warrantyId;
    private String orderId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private String remarks;

}
