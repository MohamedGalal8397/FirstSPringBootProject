package com.Mohamed.SpringDataProject;

import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;

public class EmployeeData {




    public static EmployeeEntity getEmployeeTest() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .address("Shoubra El Khiema")
                .title("Eng")
                .firstName("Mohamed")
                .lastName("Galal")
                .city("Cairo")
                .country("Egypt")
                .build();
        return employeeEntity;
    }

    public static EmployeeEntity updateEmployeeTest() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .id(999)
                .address("Shoubra El Khiema")
                .title("Eng")
                .firstName("Mohamed")
                .lastName("Galal Ahmed")
                .city("Cairo")
                .country("Egypt")
                .build();
        return employeeEntity;
    }


}
