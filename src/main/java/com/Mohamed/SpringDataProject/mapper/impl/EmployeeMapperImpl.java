


// using map struct instead of all this

//package com.Mohamed.SpringDataProject.mapper.impl;
//
//import com.Mohamed.SpringDataProject.mapper.Mapper;
//import com.Mohamed.SpringDataProject.model.dto.EmployeeDto;
//import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//
//public class EmployeeMapperImpl implements Mapper<EmployeeEntity,EmployeeDto> {
//
//    @Autowired
//    ModelMapper modelMapper;
//
//
//
//    @Override
//    public EmployeeDto mapTo(EmployeeEntity employeeEntity) {
//
//        return modelMapper.map(employeeEntity , EmployeeDto.class);
//    }
//
//    @Override
//    public EmployeeEntity mapFrom(EmployeeDto employeeDto) {
//        return modelMapper.map(employeeDto , EmployeeEntity.class);
//    }
//}
