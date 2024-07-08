package id.saputra.adi.factorypattern.service;

import id.saputra.adi.factorypattern.domain.internal.*;

public interface IBillsPayment {

    SoFRs inquirySoF();
    BillsInqRs billsInquiry(BillsInqRq billsInqRq);
    BillsPayRs billsPay(BillsPayRq billsPayRq);
}
