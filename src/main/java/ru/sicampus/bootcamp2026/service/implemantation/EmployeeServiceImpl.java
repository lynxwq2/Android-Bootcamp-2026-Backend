package ru.sicampus.bootcamp2026.service.implemantation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sicampus.bootcamp2026.dto.EmployeeDTO;
import ru.sicampus.bootcamp2026.dto.EmployeeRegDTO;
import ru.sicampus.bootcamp2026.entity.Authority;
import ru.sicampus.bootcamp2026.entity.Employee;
import ru.sicampus.bootcamp2026.entity.Place;
import ru.sicampus.bootcamp2026.exception.AuthorityNotFound;
import ru.sicampus.bootcamp2026.exception.EmployeeAlreadyExExc;
import ru.sicampus.bootcamp2026.exception.EmployeeNotFoundExc;
import ru.sicampus.bootcamp2026.exception.PlaceNotFoundExc;
import ru.sicampus.bootcamp2026.repository.AuthorityRepository;
import ru.sicampus.bootcamp2026.repository.EmployeeRepository;
import ru.sicampus.bootcamp2026.repository.PlaceRepository;
import ru.sicampus.bootcamp2026.service.EmployeeService;
import ru.sicampus.bootcamp2026.util.EmployeeMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PlaceRepository placeRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(EmployeeMapper::convertToDTO)
                .orElseThrow(() -> new EmployeeNotFoundExc("Employee isn't exist"));
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeRegDTO dto) {


        if (employeeRepository.findByUsername(dto.getUsername()).isPresent()){
            throw new EmployeeAlreadyExExc("Employee already exists");
        }

        Optional<Place> optionalPlace = placeRepository.findByName(dto.getPlaceName());
        if(optionalPlace.isEmpty()){
            throw new PlaceNotFoundExc("Place isn't valid");
        }

        Optional<Authority> roleUser  = authorityRepository.findByAuthority("ROLE_USER");
        if (roleUser.isEmpty()){
            throw new AuthorityNotFound("Auth not found((");
        }

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setUsername(dto.getUsername());
        employee.setEmail(dto.getEmail());
        employee.setPlace(optionalPlace.get());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));
        employee.setAuthorities(Set.of(roleUser.get()));
        return EmployeeMapper.convertToDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
       Employee employee = employeeRepository.findById(id)
               .orElseThrow(() -> new EmployeeNotFoundExc("Employee not found!"));

       if(employeeRepository.findByUsername(dto.getUsername()).isPresent()){
           throw new EmployeeAlreadyExExc("Employee already exists");
       }

       employee.setName(dto.getName());
       employee.setEmail(dto.getEmail());
       employee.setUsername(dto.getUsername());
       employee.setPhotoUrl(dto.getPhotoUrl());
       Optional<Place> place = placeRepository.findByName(dto.getPlaceName());
       place.ifPresent(employee::setPlace);

       return EmployeeMapper.convertToDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeByUsername(String username) {
        Optional<Employee> optionalEmployee = employeeRepository.findByUsername(username);

        if(optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundExc("Employee not found((");
        }
        return EmployeeMapper.convertToDTO(optionalEmployee.get()) ;
    }

    @Override
    public Page<EmployeeDTO> getAllEmployeePaginated(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(EmployeeMapper::convertToDTO);
    }
}
