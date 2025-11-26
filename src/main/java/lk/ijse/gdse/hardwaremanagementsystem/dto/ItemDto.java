package lk.ijse.gdse.hardwaremanagementsystem.dto;

import java.time.LocalDate;

public class ItemDto {
    private int itemId;
    private int supplierId;
    private int categoryId;
    private String name;
    private double price;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private int qty;
    private String description;
}
