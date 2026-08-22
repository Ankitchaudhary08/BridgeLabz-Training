package com.ankit.Payroll_App.Service;

import com.ankit.Payroll_App.Entity.Payroll;
import com.ankit.Payroll_App.Repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    private final PayrollRepository payrollRepository;

    public PayrollService(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    public Payroll generatePayroll(Payroll payroll) {

        int grossSalary =
                payroll.getGrossSalary();

        int deduction =
                payroll.getDeduction();

        int netSalary =
                grossSalary - deduction;

        payroll.setNetSalary(netSalary);

        return payrollRepository.save(payroll);
    }

    public List<Payroll> getAllPayroll() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {

        return payrollRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payroll not found with id: " + id
                        ));
    }

    public void deletePayroll(Long id) {

        Payroll payroll = getPayrollById(id);

        payrollRepository.delete(payroll);
    }
}