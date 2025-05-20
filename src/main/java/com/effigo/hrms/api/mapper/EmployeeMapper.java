package com.effigo.hrms.api.mapper;

import com.effigo.hrms.api.dto.EmployeeDTO;
import com.effigo.hrms.api.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
    void updateEmployeeFromDTO(EmployeeDTO employeeDTO, @MappingTarget Employee employee);
}