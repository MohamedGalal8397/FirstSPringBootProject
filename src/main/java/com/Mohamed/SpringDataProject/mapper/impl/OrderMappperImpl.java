

// using map struct instead of all this

//package com.Mohamed.SpringDataProject.mapper.impl;
//
//import com.Mohamed.SpringDataProject.mapper.Mapper;
//import com.Mohamed.SpringDataProject.model.dto.EmployeeDto;
//import com.Mohamed.SpringDataProject.model.dto.OrderDto;
//import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
//import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderMappperImpl implements Mapper<OrderEntity, OrderDto> {
//
//
//    ModelMapper modelMapper;
//
//    public OrderMappperImpl(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public OrderDto mapTo(OrderEntity orderEntity) {
//     EmployeeDto employeeDto = modelMapper.map(orderEntity.getEmployeeEntity(), EmployeeDto.class);
//
//        return modelMapper.map(orderEntity,OrderDto.class);
//    }
//
//    @Override
//    public OrderEntity mapFrom(OrderDto orderDto) {
//        return modelMapper.map(orderDto,OrderEntity.class);
//    }
//}
