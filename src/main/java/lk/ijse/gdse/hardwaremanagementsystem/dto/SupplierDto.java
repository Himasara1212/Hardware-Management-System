package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class SupplierDto {
    private String supplierId;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String companyName;
}
