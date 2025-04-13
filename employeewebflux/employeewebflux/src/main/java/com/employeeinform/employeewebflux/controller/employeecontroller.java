package com.employeeinform.employeewebflux.controller;


import com.employeeinform.employeewebflux.model.employee;
import com.employeeinform.employeewebflux.service.employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class employeecontroller {

    //inject the service layer into controller
    @Autowired
    private employeeservice employeeservice;

    @GetMapping("/displayAll")
    public Flux<employee> getAllemployees(){
        return employeeservice.getall();
    }
    @GetMapping("/{id}")
    public Mono<employee> getemployeesbyid(@PathVariable String id){
        return employeeservice.getByid(id);
    }
    @PostMapping
    public Mono<employee> createemployee(@RequestBody employee employee){
        return employeeservice.save(employee);
    }
    @PutMapping("/{id}")
    public Mono<employee> updateemployee(@PathVariable String id, @RequestBody employee employee){
        return employeeservice.updata(id,employee);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteemployee(@PathVariable String id){
        return employeeservice.delete(id);
    }


}
