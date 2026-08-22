package com.ankit.Payroll_App.Service;

import com.ankit.Payroll_App.Entity.Salary;
import com.ankit.Payroll_App.Repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Salary addSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public List<Salary> getAllSalary() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Salary not found with id: " + id));
    }

    public Salary updateSalary(Long id, Salary salary) {

        Salary existingSalary = getSalaryById(id);

        existingSalary.setEmployee_id(salary.getEmployee_id());
        existingSalary.setBasicSalary(salary.getBasicSalary());
        existingSalary.setAllowance(salary.getAllowance());
        existingSalary.setDeduction(salary.getDeduction());

        return salaryRepository.save(existingSalary);
    }

    public void deleteSalary(Long id) {

        Salary salary = getSalaryById(id);

        salaryRepository.delete(salary);
    }
}