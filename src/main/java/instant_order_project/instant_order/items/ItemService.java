package instant_order_project.instant_order.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<Item> getAll() {
        try {
            return itemsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch all items", e);
        }
    }

    public List<Integer> getAllItemsIds() {
        try {
            return itemsRepository.getAllItemIds();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch item IDs", e);
        }
    }

    public Item getItemById(Long id) {
        try {
            return itemsRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch item by ID: " + id, e);
        }
    }

    public Item addItem(Item item) {
        try {
            return itemsRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add item", e);
        }
    }

    public Item updateItem(Item item) {
        try {
            return itemsRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update item", e);
        }
    }

    public void deleteItem(Long id) {
        try {
            itemsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete item with ID: " + id, e);
        }
    }
}
