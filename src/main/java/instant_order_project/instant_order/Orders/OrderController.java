package instant_order_project.instant_order.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import instant_order_project.instant_order.items.Item;
import instant_order_project.instant_order.items.ItemService;
import instant_order_project.instant_order.logger.LoggerService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private LoggerService loggerService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        loggerService.info("Fetching all items");
        return orderService.getAll();
    }

    @PostMapping("/orders/confirm")
    public ResponseEntity<String> confirmOrder(@RequestBody Order order) {
        loggerService.info("Adding new order for item: " + order.getItemName());
        if (order.itemId == 0 || order.itemName == "" || order.price == 0 || order.quantity == 0
                || order.addressDetails.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("please fill the details correctly");
        }
        Order newOrder = new Order(order.getOrderId(), order.getItemId(), order.getItemName(), order.getPrice(),
                order.getQuantity(), order.getAddressDetails());

        List<Integer> validItemIds = itemService.getAllItemsIds();
        System.out.println("list of valid items IDs: " + validItemIds.toString());
        if (!validItemIds.contains(order.getItemId())) {
            return ResponseEntity.badRequest().body("Invalid item ID: ");
        }

        return ResponseEntity.ok().body(orderService.addOrder(newOrder).toString());
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable long id) {
        loggerService.warn("Deleting item with ID: " + id);
        orderService.deleteOrder(id);
    }

}
