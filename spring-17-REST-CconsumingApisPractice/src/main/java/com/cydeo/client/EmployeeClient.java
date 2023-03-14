package com.cydeo.client;

import com.cydeo.DTO.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "https://dummyapi.io",name= "EMPLOYEE-CLIENT")
public interface EmployeeClient {

//    @GetMapping("/data/v1/user?limit=10")//query parameter
//    Employee getEmployee(@RequestHeader("app-id") String id); // one employee based on id

    @GetMapping("/data/v1/user? limit = 10")
    Employee getEmployee(@RequestHeader("app-id") String id);
}
