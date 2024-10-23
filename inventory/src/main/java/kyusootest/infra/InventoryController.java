package kyusootest.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import kyusootest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/inventories")
@Transactional
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @GetMapping(path = "/inventories/getStock")
    public Inventory getStock(GetStockQuery getStockQuery) {
        return inventoryRepository.getStock(
            getStockQuery.getId(),
            getStockQuery.getStock(),
            getStockQuery.getProductName(),
            getStockQuery.getProductCode(),
            getStockQuery.getProductDetails(),
            getStockQuery.getMoney()
        );
    }
}
//>>> Clean Arch / Inbound Adaptor
