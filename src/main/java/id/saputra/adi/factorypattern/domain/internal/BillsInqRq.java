package id.saputra.adi.factorypattern.domain.internal;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BillsInqRq implements Serializable {
    private Long amount;
    private String customerId;
    private String biller;
}
