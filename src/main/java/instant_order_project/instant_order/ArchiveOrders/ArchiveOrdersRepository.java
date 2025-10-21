package instant_order_project.instant_order.ArchiveOrders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveOrdersRepository extends JpaRepository<Archive, Long> {

}
