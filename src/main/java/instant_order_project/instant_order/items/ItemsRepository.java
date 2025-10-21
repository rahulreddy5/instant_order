package instant_order_project.instant_order.items;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i.id FROM Item i")
    public List<Integer> getAllItemIds();
}
