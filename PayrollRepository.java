package com.example.Student2.Payroll_Component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollModel,Long> {

}
