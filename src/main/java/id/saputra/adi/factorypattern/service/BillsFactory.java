package id.saputra.adi.factorypattern.service;

import id.saputra.adi.factorypattern.constant.TranCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillsFactory {
    private final BillsPostpaidSvc billsPostpaidSvc;
    private final BillsElectricitySvc billsElectricitySvc;
    private final BillsCCSvc billsCCSvc;

    @Autowired
    public BillsFactory(BillsPostpaidSvc billsPostpaidSvc, BillsElectricitySvc billsElectricitySvc, BillsCCSvc billsCCSvc) {
        this.billsPostpaidSvc = billsPostpaidSvc;
        this.billsElectricitySvc = billsElectricitySvc;
        this.billsCCSvc = billsCCSvc;
    }

    public IBillsPayment getInstance(String tranCode){
        if (TranCode.POSTPAID.getValue().equals(tranCode)){
            return billsPostpaidSvc;
        } else if (TranCode.ELECTRICITY.getValue().equals(tranCode)){
            return billsElectricitySvc;
        } else if (TranCode.PAY_CC.getValue().equals(tranCode)){
            return billsCCSvc;
        }
        return null;
    }
}
