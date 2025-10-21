package instant_order_project.instant_order.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Order> getAll() {
        try {
            return ordersRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch all orders", e);
        }
    }

    public Order addOrder(Order order) {
        try {
            return ordersRepository.save(order);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add order", e);
        }
    }

    public void deleteOrder(Long id) {
        try {
            ordersRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete order with ID: " + id, e);
        }
    }
}
