package instant_order_project.instant_order.items;

import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import instant_order_project.instant_order.logger.LoggerService;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private LoggerService loggerService;

    @GetMapping("/splunk-test")
    public String splunkTest() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("🚀 Splunk test event at {}", System.currentTimeMillis());
        return "sent";
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        loggerService.info("Fetching all items");
        return itemService.getAll();

    }

    @PostMapping("/items")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        loggerService.info("Adding new item: " + item.getItemName());
        if (item.itemName == "" || item.itemPrice == 0 || item.availability == "") {
            return ResponseEntity.badRequest().body("please fill the details correctly");
        }
        Item savedItem = itemService.addItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItem.getItemId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/items")
    public Item updateItem(@RequestBody Item item) {
        loggerService.info("Updating item: " + item.getItemName());
        return itemService.updateItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable long id) {
        loggerService.warn("Deleting item with ID: " + id);
        itemService.deleteItem(id);
    }

}
