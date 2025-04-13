package com.employeeinform.employeewebflux.repository;

import com.employeeinform.employeewebflux.model.employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeerepository extends ReactiveMongoRepository<employee,String> {


}
