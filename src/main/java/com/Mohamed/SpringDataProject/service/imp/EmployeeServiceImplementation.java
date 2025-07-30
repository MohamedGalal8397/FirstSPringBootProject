package com.Mohamed.SpringDataProject.service.imp;


import com.Mohamed.SpringDataProject.Repository.EmployeeRepository;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
import com.Mohamed.SpringDataProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository ;




    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id) ){
        employeeRepository.deleteById(id);
        return true;
        }else {
            return false;
        }


    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {

        if (employeeRepository.existsById(employeeEntity.getId()) ){
            return employeeRepository.save(employeeEntity);
        }else{
            return null;
        }

    }

    @Override
    public Optional<EmployeeEntity> findEmployee(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<OrderEntity> findOrders(int id) {

       Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
       if(employeeEntity.isEmpty()){
           return null;
       }else{
       List< OrderEntity >orders= employeeEntity.get().getOrdersEntity();
       return orders;
       }

    }


}
