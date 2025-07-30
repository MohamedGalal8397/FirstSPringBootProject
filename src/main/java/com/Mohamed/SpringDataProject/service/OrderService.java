package com.Mohamed.SpringDataProject.service;

import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService  {



    Optional<OrderEntity> findOrder(int id);

    List<OrderEntity> findAllOrders();
    EmployeeEntity findEmployeeResponsibleOrder(int orderId);


}
