package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class OrderDetailsDTO {
    private String orderId;
    private String itemCode;
    private double price;
    private int qty;
}
