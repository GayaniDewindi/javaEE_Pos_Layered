package lk.ijse.pos.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Customer {
    String customerId;
    String customerName;
    String address;
    double salary;
}
