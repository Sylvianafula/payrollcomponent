package com.example.Student2.Payroll_Component;

import com.example.Student2.EntityResponse_Component.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @PostMapping("/addPayroll")
    public ResponseEntity addPayroll(@RequestBody PayrollModel payrollModel){
        return payrollService.addPayroll(payrollModel);
    }
    @PostMapping("/addPayrolls")
    public ResponseEntity<List<PayrollModel>> addPayrolls(@RequestBody List<PayrollModel> payrollModels){
        return payrollService.addPayrolls(payrollModels);
    }
    @PutMapping("/updatePayroll")
    public ResponseEntity updatePayroll(PayrollModel payrollModel){
        return payrollService.updatePayroll(payrollModel);
    }


}
