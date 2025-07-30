package com.Mohamed.SpringDataProject.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="orders")
public class OrderEntity {

    @Column(name ="order_id")
    @Id
  private  int id ;

    @Column(name ="customer_id")
    private String customerId;

    @Column(name ="required_date")
    private Date requiredDate;

    @Column(name ="ship_address")
    private String address;

    @Column(name ="ship_city")
    private String city;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity ;

}
