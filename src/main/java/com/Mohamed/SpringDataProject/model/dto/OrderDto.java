package com.Mohamed.SpringDataProject.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {



    private int id ;

    @NotNull(message = "customer id can't be null")
    private String customerId;

    @NotNull(message = "Required Date can't be null")
    private Date requiredDate;

    @NotNull(message = "Address Date can't be null")
    private  String address;


    private String city;

    private int employeeId ;






    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", requiredDate=" + requiredDate +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", employeeId=" + employeeId +
                "}\n";
    }
}
