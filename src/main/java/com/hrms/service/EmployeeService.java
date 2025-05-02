package com.hrms.service;

import com.hrms.dto.EmployeeDTO;
import com.hrms.entity.Employee;
import com.hrms.mapper.EmployeeMapper;
import com.hrms.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) throws Exception {
        return employeeMapper.toDTO(findEmployeeById(id));
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        validateNewEmployee(employeeDTO);
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) throws Exception {
        Employee employee = findEmployeeById(id);
        employeeMapper.updateEntityFromDTO(employeeDTO, employee);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(updatedEmployee);
    }

    public void deleteEmployee(Long id) throws Exception {
        if (!employeeRepository.existsById(id)) {
            throw new Exception("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    private Employee findEmployeeById(Long id) throws Exception {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not found with id: " + id));
    }

    private void validateNewEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (employeeRepository.existsByEmployeeId(employeeDTO.getEmployeeId())) {
            throw new IllegalArgumentException("Employee ID already exists");
        }
    }
}