package ru.sicampus.bootcamp2026.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sicampus.bootcamp2026.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
