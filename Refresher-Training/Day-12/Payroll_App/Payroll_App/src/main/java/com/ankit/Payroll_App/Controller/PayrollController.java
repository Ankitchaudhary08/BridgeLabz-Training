package com.ankit.Payroll_App.Controller;

import com.ankit.Payroll_App.Entity.Payroll;
import com.ankit.Payroll_App.Service.PayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    // Generate Payroll
    @PostMapping
    public ResponseEntity<Payroll> generatePayroll(
            @RequestBody Payroll payroll) {

        return new ResponseEntity<>(
                payrollService.generatePayroll(payroll),
                HttpStatus.CREATED
        );
    }

    // Get All Payroll
    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayroll() {

        return ResponseEntity.ok(
                payrollService.getAllPayroll()
        );
    }

    // Get Payroll By ID
    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                payrollService.getPayrollById(id)
        );
    }

    // Delete Payroll
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayroll(
            @PathVariable Long id) {

        payrollService.deletePayroll(id);

        return ResponseEntity.ok(
                "Payroll deleted successfully"
        );
    }
}