package com.effigo.hrms.api.repository;

import com.effigo.hrms.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeId(Long employeeId);
    boolean existsByEmployeeId(Long employeeId);
    boolean existsByEmail(String email);
}