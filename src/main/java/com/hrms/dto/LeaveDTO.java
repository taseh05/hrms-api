package com.hrms.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LeaveDTO {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private String reason;
    private String status;
    private String comments;
}