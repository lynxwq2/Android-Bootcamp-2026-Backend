package ru.sicampus.bootcamp2026.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import ru.sicampus.bootcamp2026.dto.EmployeeDTO;

import java.sql.Date;
import java.util.List;


@Data
@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private Date time;

    @ToStringExclude
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
