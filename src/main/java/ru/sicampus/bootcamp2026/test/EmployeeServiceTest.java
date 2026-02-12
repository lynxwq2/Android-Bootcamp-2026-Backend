package ru.sicampus.bootcamp2026.test;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sicampus.bootcamp2026.dto.EmployeeDTO;
import ru.sicampus.bootcamp2026.dto.EmployeeRegDTO;
import ru.sicampus.bootcamp2026.entity.Employee;
import ru.sicampus.bootcamp2026.repository.EmployeeRepository;
import ru.sicampus.bootcamp2026.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private  EmployeeService employeeService;



    @Test
    void testGetEmployeeById(){

        EmployeeDTO mockEmployee = new EmployeeDTO();
        mockEmployee.setId(1L);
        mockEmployee.setName("Senko");
        mockEmployee.setEmail("ex@dog.ru");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(new Employee()));

        EmployeeDTO employee = employeeService.getEmployeeById(1L);

        assertEquals("Senko", employee.getName());
        assertEquals("ex@dog.ru", employee.getEmail());
    }

}
