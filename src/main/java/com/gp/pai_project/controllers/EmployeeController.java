package com.gp.pai_project.controllers;

import com.gp.pai_project.entities.Employee;
import com.gp.pai_project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //pobranie listy wszystkich pracowników
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    //przejście do formularza dodania pracownika
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    //przejście do formularza edycji pracownika
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //pobierz pracownika z bd
        Employee theEmployee = employeeService.findById(theId);
        //ustawienie atrybutu do wypełnienia tabeli w edycji pracownika
        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    //zapisanie pracownika na podstawie formularza
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String delete(@RequestParam("employeeName") String theName,
                         Model theModel) {

        List<Employee> theEmployees = employeeService.searchBy(theName);

        theModel.addAttribute("employees", theEmployees);

        return "/employees/list-employees";
    }

    /*//pobranie konkretnego pracownika
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Pracownik o id: " + employeeId + " nie znaleziony!");
        }

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Pracownik o id: " + employeeId + " nie znaleziony!");
        }

        employeeService.deleteById(employeeId);

        return "Usunieto pracownika " + employeeId;
    }*/
}
