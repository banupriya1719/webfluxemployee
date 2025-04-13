package com.employeeinform.employeewebflux.service;

import com.employeeinform.employeewebflux.model.employee;
import com.employeeinform.employeewebflux.repository.employeerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class employeeservice {

    //inject repository layer into service layer
    @Autowired
    private employeerepository employeerepository;

    // to get all the employee from the database
    public Flux<employee> getall() {
        return employeerepository.findAll();
    }
    //get all the employee by an id
    public Mono<employee> getByid(String id){
        return employeerepository.findById(id);
        }
    // to save the data to the data base
    public Mono<employee> save(employee employee){
        return employeerepository.save(employee);
    }
    //to delete the data
    public Mono<Void> delete(String id){
        return employeerepository.deleteById(id);
    }

    //to update the data->to update the data on exiting id
    public Mono<employee> updata(String id, employee updateemployee){
        return employeerepository.findById(id)
                .flatMap(exist->{
                    //update the employee details
                   exist.setName(updateemployee.getName());
                   exist.setEmail(updateemployee.getEmail());
                   exist.setLocation(updateemployee.getLocation());
                   return employeerepository.save(exist);
                });

    }


}

