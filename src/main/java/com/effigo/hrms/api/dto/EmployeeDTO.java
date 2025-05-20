package com.effigo.hrms.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {
//    private Long  employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}