package com.ankit.Payroll_App.Repository;

import com.ankit.Payroll_App.Entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {


}
