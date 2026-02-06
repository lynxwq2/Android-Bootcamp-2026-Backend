package ru.sicampus.bootcamp2026.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class PlaceDTO {
    private long id;
    private String name;
    private Date time;
    private List<EmployeeDTO> employee;
}
