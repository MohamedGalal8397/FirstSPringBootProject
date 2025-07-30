package com.Mohamed.SpringDataProject.mapper;



import com.Mohamed.SpringDataProject.model.dto.EmployeeDto;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel= "spring")
public interface EmployeeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "title", target = "title")

    EmployeeEntity toEntity(EmployeeDto employeeDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "title", target = "title")
    EmployeeDto toDto(EmployeeEntity employeeEntity);

}
