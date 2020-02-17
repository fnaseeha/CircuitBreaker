package lk.naseeha.employeeservice.service;

import lk.naseeha.employeeservice.model.Employee;

import java.util.List;

public interface EmpService {
    public Employee save(Employee employee);

    public List<Employee> getAllEmployee();
}
