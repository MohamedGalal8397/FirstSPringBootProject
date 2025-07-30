package com.Mohamed.SpringDataProject.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {





  private   int id ;

    @NotBlank (message   ="first name can't be blank")
    @Pattern(regexp = "^[A-Za-z]+$" , message="Invalid first name")
    private String firstName;


    @NotBlank (message   ="last name can't be blank")
    @Pattern(regexp = "^[A-Za-z]+$" , message="Invalid name")
    private String lastName;


    @Pattern(regexp = "^[A-Za-z]+$" , message="Invalid title")
    private String title;

    @NotNull(message = "address can't be null")
    private String address ;

    @NotNull (message = "city can't be null")
    private String city;

    @NotNull (message = "country can't be null")
    @Pattern(regexp = "Egypt" , message = "Country must be Egypt")
    private String country;



}
