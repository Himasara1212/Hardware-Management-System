package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class CustomerDto {
    private String customerId;
    private String name;
    private String contact;
    private String email;
    private String address;
}
