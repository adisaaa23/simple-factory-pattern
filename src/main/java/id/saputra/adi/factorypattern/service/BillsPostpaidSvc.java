package id.saputra.adi.factorypattern.service;

import id.saputra.adi.factorypattern.constant.SoF;
import id.saputra.adi.factorypattern.constant.TranCode;
import id.saputra.adi.factorypattern.domain.internal.BillsInqRs;
import id.saputra.adi.factorypattern.domain.internal.BillsPayRs;
import id.saputra.adi.factorypattern.domain.internal.SoFRs;
import id.saputra.adi.factorypattern.domain.esb.PostpaidInqRq;
import id.saputra.adi.factorypattern.domain.esb.PostpaidInqRs;
import id.saputra.adi.factorypattern.domain.esb.PostpaidPayRq;
import id.saputra.adi.factorypattern.domain.esb.PostpaidPayRs;
import org.springframework.stereotype.Service;

@Service
public class BillsPostpaidSvc extends ABillsPayment {
    @Override
    String tranCode() {
        return TranCode.POSTPAID.getValue();
    }

    @Override
    SoFRs sofFilter(String filterType, String [] accountType) {
        return super.sofFilter(
                SoF.FilterType.BLACKLIST.name(),
                new String[]{SoF.AccountType.WALLET_ACCOUNT.name()}
        );
    }

    @Override
    Object constructInqRq() {
        return new PostpaidInqRq();
    }

    @Override
    Object callInqApi(Object apiRq) {
        return new PostpaidInqRs();
    }

    @Override
    BillsInqRs constructInqRs(Object apiRs) {
        PostpaidInqRs postpaidInqRs = (PostpaidInqRs) apiRs;
        return new BillsInqRs();
    }

    @Override
    Object constructPayRq() {
        return new PostpaidPayRq();
    }

    @Override
    Object callPayApi(Object apiRq) {
        return new PostpaidPayRs();
    }

    @Override
    BillsPayRs constructPayRs(Object apiRs) {
        PostpaidPayRs postpaidPayRs = (PostpaidPayRs) apiRs;
        return new BillsPayRs();
    }
}
