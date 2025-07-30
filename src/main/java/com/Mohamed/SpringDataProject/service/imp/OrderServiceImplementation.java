package com.Mohamed.SpringDataProject.service.imp;

import com.Mohamed.SpringDataProject.Repository.EmployeeRepository;
import com.Mohamed.SpringDataProject.Repository.OrderRepository;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
import com.Mohamed.SpringDataProject.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

   OrderRepository orderRepository ;
    EmployeeRepository employeeRepository;
    public OrderServiceImplementation(OrderRepository orderRepository , EmployeeRepository employeeRepository) {
        this.orderRepository = orderRepository;
        this.employeeRepository =employeeRepository;
    }


    @Override
    public Optional<OrderEntity> findOrder(int id) {

      Optional<OrderEntity> orderEntity = orderRepository.findById(id);

        return orderEntity;
    }

    @Override
    public List<OrderEntity> findAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public EmployeeEntity  findEmployeeResponsibleOrder(int orderId) {

     Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);

       if(orderEntity.isEmpty()){
           return null ;
       }else{

           OrderEntity order = orderEntity.get();
        EmployeeEntity employeeEntity =   order.getEmployeeEntity();

           return employeeEntity;
       }



    }
}
