package com.Mohamed.SpringDataProject.service;

import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

   EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
   boolean deleteEmployee(int id);
   EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
  Optional<EmployeeEntity> findEmployee(int id);
  List<EmployeeEntity> findAllEmployee();
List<OrderEntity> findOrders(int id);


}
