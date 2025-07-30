package com.Mohamed.SpringDataProject.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id ;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address ;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private   String country;


    @JsonIgnore
    @Column(name ="home_phone")
    private  String homePhone;


    @OneToMany(mappedBy = "employeeEntity")
    private List<OrderEntity>ordersEntity;




}
