package com.Mohamed.SpringDataProject.Controller;


import com.Mohamed.SpringDataProject.EmployeeData;
import com.Mohamed.SpringDataProject.mapper.EmployeeMapper;
import com.Mohamed.SpringDataProject.model.dto.EmployeeDto;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.service.imp.EmployeeServiceImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class EmployeeEmployeeControllerTest {

    MockMvc mockMvc ;
    ObjectMapper objectMapper ;
    EmployeeServiceImplementation employeeServiceImplementation;
    EmployeeMapper employeeMapper ;

    @Autowired
    public EmployeeEmployeeControllerTest(MockMvc mockMvc, ObjectMapper objectMapper, EmployeeServiceImplementation employeeServiceImplementation, EmployeeMapper employeeMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.employeeServiceImplementation = employeeServiceImplementation;
        this.employeeMapper = employeeMapper;
    }


    @Test
    @DisplayName("controller test  for Saving new  Employee  ")
    public void createEmployeeControllerTest() throws Exception {

        EmployeeEntity employeeEntity = EmployeeData.getEmployeeTest();
       EmployeeDto employeeDto = employeeMapper.toDto(employeeEntity);
       String json= objectMapper.writeValueAsString(employeeDto);


        mockMvc.perform(
                MockMvcRequestBuilders.post("/Employee/addEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )       .andExpect( MockMvcResultMatchers.status().isCreated() )
                .andExpect(  MockMvcResultMatchers.jsonPath("$.firstName").value("Mohamed")   )
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Galal"));

    }

    @Test
    @DisplayName("controller test  for getting Employees ")
    public void getEmployeeControllerTest()throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.get("/Employee/getEmployees")
                        .contentType(MediaType.APPLICATION_JSON)
        )       .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.jsonPath("$[0].firstName").value("Nancy"))
                .andExpect( MockMvcResultMatchers.jsonPath("$[5].firstName").value("Michael"));
    }

    @Test
    @DisplayName("Controller Test for deleting Employee with Correct id")
    public void deleteEmployeeControllerTest()throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/Employee/deleteEmployee")
                        .param("id" , "1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect( MockMvcResultMatchers.status().isAccepted());

    }


    @Test
    @DisplayName("Controller Test for deleting Employee with Wrong id")
    public void deleteEmployeeWrongIdControllerTest()throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/Employee/deleteEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id" , "555")

        ).andExpect( MockMvcResultMatchers.status().isNotFound());

    }




    @Test
    @DisplayName("Test Updating employee data")
    public void updateEmployeeControllerTest()throws Exception{

        EmployeeEntity employeeEntity = EmployeeData.updateEmployeeTest();
       EmployeeDto employeeDto= employeeMapper.toDto(employeeEntity);
       String json = objectMapper.writeValueAsString(employeeDto);


        mockMvc.perform(
                MockMvcRequestBuilders.post("/Employee/updateEmployee")
                        .contentType(MediaType.APPLICATION_JSON).
                        content(json)
        ).andExpect( MockMvcResultMatchers.jsonPath("$.firstName").value("Mohamed") );

    }


}
