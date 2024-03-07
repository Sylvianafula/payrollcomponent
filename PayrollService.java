package com.example.Student2.Payroll_Component;

import com.example.Student2.EntityResponse_Component.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

public ResponseEntity addPayroll(PayrollModel payrollModel){
    ResponseEntity responseEntity = new ResponseEntity<>();
    try{
        PayrollModel savedPayroll = payrollRepository.save(payrollModel);
        responseEntity.setEntity(savedPayroll);
        responseEntity.setMessage("Payroll added successfully!");
        responseEntity.setStatusCode(HttpStatus.CREATED.value());
    } catch (Exception e) {
        log.error("Error while adding payroll");
        responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseEntity.setMessage("Internal Server Error");
        responseEntity.setEntity(null);
    }
    return responseEntity;
}
public ResponseEntity<List<PayrollModel>> addPayrolls(List<PayrollModel> payrollModels){
    ResponseEntity<List<PayrollModel>> responseEntity = new ResponseEntity<>();
    try {
        List<PayrollModel> listPayroll =  payrollRepository.saveAll(payrollModels);
        responseEntity.setEntity(listPayroll);
        responseEntity.setMessage("Payrolls retrieved successfully");
        responseEntity.setStatusCode(HttpStatus.OK.value());
    } catch (Exception e) {
        log.error("Error encountered while adding payrolls!!");
        responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseEntity.setMessage("Internal Server Error");
        responseEntity.setEntity(null);
    }
    return responseEntity;
}
public ResponseEntity updatePayroll(PayrollModel payrollModel){
    ResponseEntity responseEntity = new ResponseEntity<>();
    Optional<PayrollModel> existingPayroll = payrollRepository.findById(payrollModel.getId());
    try {
        if (existingPayroll.isPresent()){
            PayrollModel updatePayroll = existingPayroll.get();
            updatePayroll.setDate(payrollModel.getDate());
            updatePayroll.setAccountNo(payrollModel.getAccountNo());
             PayrollModel updatedPayroll = payrollRepository.save(updatePayroll);
             responseEntity.setEntity(updatedPayroll);
             responseEntity.setMessage("Payroll updated successfully");
             responseEntity.setStatusCode(HttpStatus.OK.value());
        }else {
            responseEntity.setMessage("Payroll Not Found");
            responseEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseEntity.setEntity(null);

        }
    } catch (Exception e) {
        log.error("Error while updating payroll");
        responseEntity.setEntity(null);
        responseEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseEntity.setMessage("Internal Server Error");
    }
    return responseEntity;
}
}
