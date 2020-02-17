package lk.naseeha.employeeservice.service;

import lk.naseeha.employeeservice.Repository.EmployeeRepository;
import lk.naseeha.employeeservice.hystrix.AllocationCommand;
import lk.naseeha.employeeservice.model.Allocation;
import lk.naseeha.employeeservice.model.Employee;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmpService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    HttpHeaders httpHeaders;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Employee save(Employee employee) {
        employeeRepository.save(employee);

        return employee;
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
    	return new RestTemplate();
    }
    
    

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id) {
    	Optional<Employee> employee= employeeRepository.findById(id);
    	if(employee.isPresent()){
    		Employee emp =  employee.get();
    		emp.setAllocation(fetchAllocation(id));
    	}
    	return null;
    }
    
    public Allocation[] fetchAllocation(Integer id){
    	Employee employee = this.getEmployee(id);
    	AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);
    	
    	return allocationCommand.execute();
    	
    }
}