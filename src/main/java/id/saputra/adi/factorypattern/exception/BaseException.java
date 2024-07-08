package id.saputra.adi.factorypattern.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private final String sourceSystem;
    private final String errorCode;
}
