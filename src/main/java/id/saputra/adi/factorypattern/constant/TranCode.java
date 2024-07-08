package id.saputra.adi.factorypattern.constant;

import lombok.Getter;

@Getter
public enum TranCode {

    POSTPAID("9001"),
    ELECTRICITY("9002"),
    PAY_CC("9003");
    private final String value;
    TranCode(String value) {
        this.value = value;
    }
}
