package ru.sicampus.bootcamp2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.sicampus.bootcamp2026.dto.EmployeeDTO;
import ru.sicampus.bootcamp2026.dto.EmployeeRegDTO;
import ru.sicampus.bootcamp2026.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO>  getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeRegDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(dto));
    }

    @GetMapping("/login")
    public ResponseEntity<EmployeeDTO> login(Authentication authentication){
        return ResponseEntity.ok(employeeService.getEmployeeByUsername(authentication.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto){
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<String> getByUsername(@PathVariable String username){
        EmployeeDTO employeeDTO = employeeService.getEmployeeByUsername(username);
        return ResponseEntity.ok("User" + employeeDTO.getUsername() + "is registered");
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<EmployeeDTO>> getAllEmployeePaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(employeeService.getAllEmployeePaginated(pageable));
    }
}


