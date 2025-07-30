package com.Mohamed.SpringDataProject.Controller;


import com.Mohamed.SpringDataProject.mapper.EmployeeMapper;
//import com.Mohamed.SpringDataProject.mapper.impl.EmployeeMapperImpl;
import com.Mohamed.SpringDataProject.mapper.OrderMapper;
//import com.Mohamed.SpringDataProject.mapper.impl.OrderMappperImpl;
import com.Mohamed.SpringDataProject.model.dto.EmployeeDto;
import com.Mohamed.SpringDataProject.model.dto.OrderDto;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
import com.Mohamed.SpringDataProject.service.imp.EmployeeServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("Employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImplementation employeeServiceImplementation;

    @Autowired
    EmployeeMapper employeeMapper ;

    @Autowired
    OrderMapper orderMapper ;

    // using map struct
  /*  @Autowired
    EmployeeMapperImpl employeeMapper;

    @Autowired
    OrderMappperImpl orderMappper;

   */

    @GetMapping("/getEmployee")
    public ResponseEntity<?> getEmployee(@RequestParam  int id ){

      Optional <EmployeeEntity> employeeEntity = employeeServiceImplementation.findEmployee(id);

        if (employeeEntity.isEmpty()) {

            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error", "It is invalid id");
            return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND  );

        }else{
            EmployeeDto employeeDto = employeeMapper.toDto(employeeEntity.get());
            /*

                // using map struct
      EmployeeDto employeeDto = employeeMapper.mapTo(employeeEntity.get());

             */

        HttpHeaders header = new HttpHeaders();
        header.add("name" , "Mohamed Galal");
        return new ResponseEntity<>(employeeDto, header,HttpStatus.OK);
        }

    }


    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){

        /*
        // use map struct

       EmployeeEntity employeeEntity = employeeMapper.mapFrom(employeeDto);


       EmployeeDto employee = employeeMapper.mapTo( employeeServiceImplementation.saveEmployee(employeeEntity) );

         */
        EmployeeEntity employeeEntity = employeeMapper.toEntity(employeeDto);
        EmployeeDto employee = employeeMapper.toDto(employeeServiceImplementation.saveEmployee(employeeEntity));

       return new ResponseEntity<>(employee ,HttpStatus.CREATED);
    }


    @GetMapping("/getEmployees")
    public List<EmployeeDto> getEmployees(){

        List<EmployeeEntity> employeeEntities = employeeServiceImplementation.findAllEmployee();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for(EmployeeEntity employeeEntity : employeeEntities){
            employeeDtos.add(employeeMapper.toDto(employeeEntity));
            /*
            // using map stuct
           employeeDtos.add( employeeMapper.mapTo(employeeEntity) );

             */
        }

        return  employeeDtos;
    }


    @PostMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody @Valid EmployeeDto employeeDto){

        EmployeeEntity employeeEntity =  employeeMapper.toEntity(employeeDto);

      //EmployeeEntity employeeEntity=  employeeMapper.mapFrom(employeeDto);
      EmployeeEntity employeeEntityUpdated = employeeServiceImplementation.updateEmployee(employeeEntity);
      if(employeeEntityUpdated== null){

          Map<String, String> errorBody = new HashMap<>();
          errorBody.put("error", "It is invalid id");
          return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND  );
      }else{
          EmployeeDto employeeDtoUpdated= employeeMapper.toDto(employeeEntityUpdated);
            //using map struct
          // EmployeeDto employeeDtoUpdated=employeeMapper.mapTo(employeeEntityUpdated );
          return new ResponseEntity<>(employeeDtoUpdated , HttpStatus.OK) ;
      }
    }



    @DeleteMapping("/deleteEmployee")
    public  ResponseEntity deleteEmployee( @RequestParam @Valid int id){

        if (employeeServiceImplementation.deleteEmployee(id) ) {
            Map<String, String> body = new HashMap<>();
            body.put("message" , "Employee is deleted");
            return  new ResponseEntity(body ,HttpStatus.ACCEPTED);
        }else {
            Map<String, String> body = new HashMap<>();
            body.put("error" , "invalid id");
            return  new ResponseEntity(body ,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOrdersByEmployeeId")
    public ResponseEntity<?> getOrdersByEmployeeID(@RequestParam int id){

       List <OrderEntity> ordersEntity= employeeServiceImplementation.findOrders(id);
       if (ordersEntity ==null){
           Map<String, String> body = new HashMap<>();
           body.put("message" , "Employee is Not Found");
           return  new ResponseEntity(body ,HttpStatus.ACCEPTED);
       }else{
           List< OrderDto > orderDtos = new ArrayList<>();
           for(OrderEntity orderEntity :ordersEntity){

               orderDtos.add( orderMapper.toDto(orderEntity));
               // using map struct
              // orderDtos.add( orderMappper.mapTo(orderEntity));
           }
           if (orderDtos.size()==0){
               String message ="This employee has no orders done";
               return  new ResponseEntity(message ,HttpStatus.ACCEPTED);
           }

           return  new ResponseEntity(orderDtos ,HttpStatus.ACCEPTED);

       }
    }



}
