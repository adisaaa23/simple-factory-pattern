package id.saputra.adi.factorypattern.domain.internal;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class SoFRs implements Serializable {
    private List<SoF> accountNumber;
    @Data
    @NoArgsConstructor
    public static class SoF implements Serializable {
        String accountNumber;
        Long balance;
    }
}
