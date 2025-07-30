package com.Mohamed.SpringDataProject.mapper;

import com.Mohamed.SpringDataProject.model.dto.OrderDto;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "requiredDate", target = "requiredDate")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "employeeEntity.id", target = "employeeId")
    OrderDto toDto(OrderEntity orderEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "requiredDate", target = "requiredDate")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")

    @Mapping(target = "employeeEntity", expression = "java(employeeFromId(orderDto.getEmployeeId()))")
    OrderEntity toEntity(OrderDto orderDto);

    // دالة مساعدة لتحويل ID فقط إلى EmployeeEntity
    default EmployeeEntity employeeFromId(int id) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(id);
        return employee;
    }
}
