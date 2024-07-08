package id.saputra.adi.factorypattern.service;

import id.saputra.adi.factorypattern.constant.SoF;
import id.saputra.adi.factorypattern.constant.TranCode;
import id.saputra.adi.factorypattern.domain.internal.BillsInqRs;
import id.saputra.adi.factorypattern.domain.internal.BillsPayRs;
import id.saputra.adi.factorypattern.domain.internal.SoFRs;
import id.saputra.adi.factorypattern.domain.esb.CCPayInqRq;
import id.saputra.adi.factorypattern.domain.esb.CCPayInqRs;
import id.saputra.adi.factorypattern.domain.esb.CCPayRq;
import id.saputra.adi.factorypattern.domain.esb.CCPayRs;
import org.springframework.stereotype.Service;

@Service
public class BillsCCSvc extends ABillsPayment {
    @Override
    String tranCode() {
        return TranCode.PAY_CC.getValue();
    }

    @Override
    SoFRs sofFilter(String filterType, String[] accountType) {
        return super.sofFilter(
                SoF.FilterType.BLACKLIST.name(),
                new String[]{SoF.AccountType.CREDIT_ACCOUNT.name()}
        );
    }

    @Override
    Object constructInqRq() {
        return new CCPayInqRq();
    }

    @Override
    Object callInqApi(Object apiRq) {
        return new CCPayInqRs();
    }

    @Override
    BillsInqRs constructInqRs(Object apiRs) {
        CCPayInqRs inqRs = (CCPayInqRs) apiRs;
        return new BillsInqRs();
    }

    @Override
    Object constructPayRq() {
        return new CCPayRq();
    }

    @Override
    Object callPayApi(Object apiRq) {
        return new CCPayRs();
    }

    @Override
    BillsPayRs constructPayRs(Object apiRs) {
        CCPayRs payRs = (CCPayRs) apiRs;
        return new BillsPayRs();
    }
}
