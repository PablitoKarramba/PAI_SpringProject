package com.gp.pai_project.services;

import com.gp.pai_project.repository.EmployeeRepository;
import com.gp.pai_project.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByNazwiskoAsc();
    }

    @Override
    public Employee findById(int theId) {
        //Optional chroni przed NULLEM
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            //nie ma takiego ID
            throw new RuntimeException("W bazie nie ma pracownika o ID: " + theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public List<Employee> searchBy(String theName) {

        List<Employee> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = employeeRepository.findByImieContainsOrNazwiskoContainsAllIgnoreCase(theName,theName);
        }
        else {
            results = findAll();
        }

        return results;
    }
}
