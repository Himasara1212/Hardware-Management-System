package lk.ijse.gdse.hardwaremanagementsystem.dto;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsDto {
    private String itemId;
    private String supId;
    private String categoryId;
    private String name;
    private double price;
    private int qty;
}
