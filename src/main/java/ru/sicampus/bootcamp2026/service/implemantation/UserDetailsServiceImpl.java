package ru.sicampus.bootcamp2026.service.implemantation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sicampus.bootcamp2026.entity.Employee;
import ru.sicampus.bootcamp2026.exception.EmployeeNotFoundExc;
import ru.sicampus.bootcamp2026.repository.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findByUsername(username);

        if(optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundExc("Employee not found((");
        }
        return optionalEmployee.get() ;
    }
}
