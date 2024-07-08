package id.saputra.adi.factorypattern.service;

import id.saputra.adi.factorypattern.constant.TranCode;
import id.saputra.adi.factorypattern.domain.internal.BillsInqRs;
import id.saputra.adi.factorypattern.domain.internal.BillsPayRs;
import id.saputra.adi.factorypattern.domain.esb.ElectricityInqRq;
import id.saputra.adi.factorypattern.domain.esb.ElectricityInqRs;
import id.saputra.adi.factorypattern.domain.esb.ElectricityPayRq;
import id.saputra.adi.factorypattern.domain.esb.ElectricityPayRs;
import org.springframework.stereotype.Service;

@Service
public class BillsElectricitySvc extends ABillsPayment {
    @Override
    String tranCode() {
        return TranCode.ELECTRICITY.getValue();
    }

    @Override
    Object constructInqRq() {
        return new ElectricityInqRq();
    }

    @Override
    Object callInqApi(Object apiRq) {
        return new ElectricityInqRs();
    }

    @Override
    BillsInqRs constructInqRs(Object apiRs) {
        ElectricityInqRs inqRs = (ElectricityInqRs) apiRs;
        return new BillsInqRs();
    }

    @Override
    Object constructPayRq() {
        return new ElectricityPayRq();
    }

    @Override
    Object callPayApi(Object apiRq) {
        return new ElectricityPayRs();
    }

    @Override
    BillsPayRs constructPayRs(Object apiRs) {
        ElectricityPayRs payRs = (ElectricityPayRs) apiRs;
        return new BillsPayRs();
    }
}

