package lk.ijse.pos.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetails {
    private String orderId;
    private String code;
    private double price;
    private int qty;
}
