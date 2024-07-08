package id.saputra.adi.factorypattern.domain.internal;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BillsPayRs implements Serializable {
    private String statusCode;
}
