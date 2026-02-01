package ru.sicampus.bootcamp2026.service.implemantation;

import ru.sicampus.bootcamp2026.dto.EmployeeDTO;
import ru.sicampus.bootcamp2026.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return null;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        return null;
    }

    @Override
    public void deleteEmployee(long id) {

    }
}
