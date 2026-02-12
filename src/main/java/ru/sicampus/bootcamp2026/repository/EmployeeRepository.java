package ru.sicampus.bootcamp2026.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sicampus.bootcamp2026.entity.Employee;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUsername(String username);
    Optional<Employee> findById(Long id);

    @Override
    Page<Employee> findAll(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"place", "authorities"})
    List<Employee> findAll();
}
