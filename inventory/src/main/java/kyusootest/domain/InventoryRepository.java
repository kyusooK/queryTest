package kyusootest.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="inventories", path="inventories")
public interface InventoryRepository extends PagingAndSortingRepository<Inventory, Long>{
   @Query(value = "select inventory " +
        "from Inventory inventory " +
        "where (:id is null or inventory.id = :id) " +
        "and (:stock is null or inventory.stock = :stock) " +
        "and (:productName is null or inventory.productName like %:productName%) " +
        "and (:productCode is null or inventory.productCode = :productCode) " + // 수정된 부분
        "and (:amount is null or inventory.money.amount = :amount) " + // 수정된 부분
        "and (:currency is null or inventory.money.currency = :currency)") // 수정된 부분
   Inventory getStock(Long id, Integer stock, String productName, ProductCode productCode, Double amount, String currency);
}