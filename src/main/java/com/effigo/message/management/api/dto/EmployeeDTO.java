package com.effigo.message.management.api.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
}