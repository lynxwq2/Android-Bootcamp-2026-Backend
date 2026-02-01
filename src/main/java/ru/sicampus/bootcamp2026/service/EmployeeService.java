package ru.sicampus.bootcamp2026.service;

import ru.sicampus.bootcamp2026.dto.EmployeeDTO;
import ru.sicampus.bootcamp2026.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO dto);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);

    void deleteEmployee(long id);
}
