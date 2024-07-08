package id.saputra.adi.factorypattern.controller;

import id.saputra.adi.factorypattern.constant.TranCode;
import id.saputra.adi.factorypattern.domain.internal.*;
import id.saputra.adi.factorypattern.service.BillsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class BillsPostpaidController {

    private final BillsFactory billsFactory;

    @Autowired
    public BillsPostpaidController(BillsFactory billsFactory) {
        this.billsFactory = billsFactory;
    }

    @PostMapping("/postpaid/sof")
    public SoFRs inquirySoF(){
        return billsFactory.getInstance(TranCode.POSTPAID.getValue()).inquirySoF();
    }

    @PostMapping("/postpaid/inquiry")
    public BillsInqRs inquirySoF(@RequestBody BillsInqRq billsInqRq){
        return billsFactory.getInstance(TranCode.POSTPAID.getValue()).billsInquiry(billsInqRq);
    }

    @PostMapping("/postpaid/payment")
    public BillsPayRs inquirySoF(@RequestBody BillsPayRq billsPayRq){
        return billsFactory.getInstance(TranCode.POSTPAID.getValue()).billsPay(billsPayRq);
    }
}
