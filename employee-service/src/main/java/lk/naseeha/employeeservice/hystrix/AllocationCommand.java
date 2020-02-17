package lk.naseeha.employeeservice.hystrix;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import lk.naseeha.employeeservice.model.Allocation;
import lk.naseeha.employeeservice.model.Employee;

public class AllocationCommand extends HystrixCommand<Allocation[]> {
	
	
	private Employee employee;
	private HttpHeaders httpHeaders;
	private RestTemplate restTemplate;
	
	public AllocationCommand( Employee employee, HttpHeaders httpHeaders,
			RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.employee = employee;
		this.httpHeaders = httpHeaders;
		this.restTemplate = restTemplate;
	}

	@Override
	protected Allocation[] run() throws Exception {
		
		HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

		ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
				"http://allocation/services/getbyid/" + employee.getId(), HttpMethod.GET, httpEntity,
				Allocation[].class);

		return responseEntity.getBody();
	}
	
	Allocation[] getFallBack(){
		return new Allocation[1];
	}
	
	

}
