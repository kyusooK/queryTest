package kyusootest.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class GetStockQuery {

    private Long id;
    private Integer stock;
    private String productName;
    private ProductCode productCode;
    private List<ProductDetail> productDetails;
    private Money money;
}