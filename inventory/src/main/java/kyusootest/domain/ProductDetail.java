package kyusootest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productSize;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String originalCompany;
}
//>>> DDD / Value Object
