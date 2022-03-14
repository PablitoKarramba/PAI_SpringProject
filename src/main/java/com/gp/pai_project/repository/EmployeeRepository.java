package com.gp.pai_project.repository;

import com.gp.pai_project.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //sortowanie wg nazwiska
    public List<Employee> findAllByOrderByNazwiskoAsc();

    //szukanie po imieniu
    public List<Employee> findByImieContainsOrNazwiskoContainsAllIgnoreCase(String Imie, String Nazwisko);
}
