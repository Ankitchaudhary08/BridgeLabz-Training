package com.ankit.Payroll_App.Controller;


import com.ankit.Payroll_App.Entity.Salary;
import com.ankit.Payroll_App.Service.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    // Add Salary
    @PostMapping
    public ResponseEntity<Salary> addSalary(
            @RequestBody Salary salary) {

        return new ResponseEntity<>(
                salaryService.addSalary(salary),
                HttpStatus.CREATED
        );
    }

    // Get All Salaries
    @GetMapping
    public ResponseEntity<List<Salary>> getAllSalary() {

        return ResponseEntity.ok(
                salaryService.getAllSalary()
        );
    }

    // Get Salary By ID
    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                salaryService.getSalaryById(id)
        );
    }

    // Update Salary
    @PutMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(
            @PathVariable Long id,
            @RequestBody Salary salary) {

        return ResponseEntity.ok(
                salaryService.updateSalary(id, salary)
        );
    }

    // Delete Salary
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalary(
            @PathVariable Long id) {

        salaryService.deleteSalary(id);

        return ResponseEntity.ok(
                "Salary deleted successfully"
        );
    }
}