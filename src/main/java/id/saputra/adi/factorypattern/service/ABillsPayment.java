package id.saputra.adi.factorypattern.service;

import id.saputra.adi.factorypattern.constant.SoF;
import id.saputra.adi.factorypattern.domain.internal.*;
import id.saputra.adi.factorypattern.exception.BalanceException;

public abstract class ABillsPayment implements IBillsPayment {

    abstract String tranCode();

    @Override
    public SoFRs inquirySoF() {
        return sofFilter(
                SoF.FilterType.WHITELIST.name(),
                new String[]{SoF.AccountType.SAVING_ACCOUNT.name(), SoF.AccountType.CURRENT_ACCOUNT.name()}
        );
    }

    SoFRs sofFilter(String filterType, String [] accountType){
        //TODO logical filter
        return new SoFRs();
    }
    SoFRs.SoF selectedSoF(){
        return new SoFRs.SoF();
    }

    @Override
    public BillsInqRs billsInquiry(BillsInqRq billsInqRq) {
        SoFRs.SoF selectedSoF = selectedSoF();
        balanceValidation(billsInqRq.getAmount(), selectedSoF.getBalance());
        limitValidation(billsInqRq.getAmount(), tranCode());
        Object esbRq = constructInqRq();
        Object esbRs = callInqApi(esbRq);
        BillsInqRs billsInqRs = constructInqRs(esbRs);
        return billsInqRs;
    }

    abstract Object constructInqRq();
    abstract Object callInqApi(Object apiRq);
    abstract BillsInqRs constructInqRs(Object apiRs);

    void balanceValidation(Long amount, Long balance){
        if (amount >= balance){
            throw new BalanceException("", "");
        }
    }

    void limitValidation(Long amount, String tranCode){
        //TODO call rest API limit validation
    }

    @Override
    public BillsPayRs billsPay(BillsPayRq billsPayRq) {
        Object esbPayRq = constructPayRq();
        Object esbPayRs = callPayApi(esbPayRq);
        BillsPayRs payRs = constructPayRs(esbPayRs);
        if ("00".equals(payRs.getStatusCode())){
            updateLimit(billsPayRq.getAmount(), tranCode());
        }
        return payRs;
    }

    abstract Object constructPayRq();
    abstract Object callPayApi(Object apiRq);
    abstract BillsPayRs constructPayRs(Object apiRs);
    void updateLimit(Long amount, String tranCode){
        //TODO call rest API limit update
    }
}
