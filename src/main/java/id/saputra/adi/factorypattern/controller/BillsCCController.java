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
public class BillsCCController {

    private final BillsFactory billsFactory;

    @Autowired
    public BillsCCController(BillsFactory billsFactory) {
        this.billsFactory = billsFactory;
    }

    @PostMapping("/cc/sof")
    public SoFRs inquirySoF(){
        return billsFactory.getInstance(TranCode.PAY_CC.getValue()).inquirySoF();
    }

    @PostMapping("/cc/inquiry")
    public BillsInqRs inquirySoF(@RequestBody BillsInqRq billsInqRq){
        return billsFactory.getInstance(TranCode.PAY_CC.getValue()).billsInquiry(billsInqRq);
    }

    @PostMapping("/cc/payment")
    public BillsPayRs inquirySoF(@RequestBody BillsPayRq billsPayRq){
        return billsFactory.getInstance(TranCode.PAY_CC.getValue()).billsPay(billsPayRq);
    }
}
