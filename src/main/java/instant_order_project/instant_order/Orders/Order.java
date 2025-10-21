package instant_order_project.instant_order.Orders;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
// import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates no-args constructor

@Table(name = "orders") // Generates constructor with all fields
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    int itemId;
    String itemName;
    double price;
    int quantity;
    private double totalPrice;
    String addressDetails;

    public Order(Long orderId, int itemId, String itemName, double price, int quantity,
            String addressDetails) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.addressDetails = addressDetails;
    }

}
