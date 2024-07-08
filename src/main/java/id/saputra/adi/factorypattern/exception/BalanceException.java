package id.saputra.adi.factorypattern.exception;

public class BalanceException extends BaseException{
    public BalanceException(String sourceSystem, String errorCode) {
        super(sourceSystem, errorCode);
    }
}
