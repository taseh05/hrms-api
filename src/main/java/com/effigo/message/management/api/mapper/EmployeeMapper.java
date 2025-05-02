package com.effigo.message.management.api.mapper;

import com.effigo.message.management.api.dto.EmployeeDTO;
import com.effigo.message.management.api.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
    void updateEmployeeFromDTO(EmployeeDTO employeeDTO, @MappingTarget Employee employee);
}