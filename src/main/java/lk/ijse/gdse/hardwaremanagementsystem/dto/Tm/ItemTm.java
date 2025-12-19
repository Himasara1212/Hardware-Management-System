package lk.ijse.gdse.hardwaremanagementsystem.dto.Tm;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemTm {
    private String itemId;
    private String name;
    private int qty;
    private double price;
    private String supId;
    private String supName;
}