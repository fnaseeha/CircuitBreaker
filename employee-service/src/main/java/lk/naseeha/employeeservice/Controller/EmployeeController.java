package lk.naseeha.employeeservice.Controller;

import lk.naseeha.employeeservice.model.Employee;
import lk.naseeha.employeeservice.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/employee" , method = RequestMethod.POST)
    public Employee getEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/emp/{id}" , method = RequestMethod.GET)
    public Employee getEmployee(Integer id){
        return employeeService.getEmployee(id);
    }
}
