package com.Mohamed.SpringDataProject.Controller;


import com.Mohamed.SpringDataProject.mapper.EmployeeMapper;
//import com.Mohamed.SpringDataProject.mapper.impl.OrderMappperImpl;
import com.Mohamed.SpringDataProject.mapper.OrderMapper;
import com.Mohamed.SpringDataProject.model.dto.EmployeeDto;
import com.Mohamed.SpringDataProject.model.dto.OrderDto;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
import com.Mohamed.SpringDataProject.service.imp.EmployeeServiceImplementation;
import com.Mohamed.SpringDataProject.service.imp.OrderServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {

    OrderMapper orderMapper ;
    EmployeeMapper employeeMapper;
    /*
    // using map struct
    OrderMappperImpl orderMappper ;
    EmployeeMapperImpl employeeMapper;
     */

    OrderServiceImplementation orderService;
    EmployeeServiceImplementation employeeService;




    public OrderController(OrderMapper orderMapper, OrderServiceImplementation orderService, EmployeeMapper employeeMapper,EmployeeServiceImplementation employeeService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.employeeService=employeeService;
        this.employeeMapper=employeeMapper;
    }

    @GetMapping("/getAllOrders")
    public List<OrderDto> getAllOrders(){

        List<OrderEntity> oredrsEntity =orderService.findAllOrders();
        List<OrderDto> ordersDto= new ArrayList<>();

        for(OrderEntity orderEntity : oredrsEntity)
        {
            ordersDto.add( orderMapper.toDto(orderEntity));
            /*
            // using map struct
            ordersDto.add( orderMappper.mapTo(orderEntity) );

             */
        }
       return ordersDto ;
    }



    @GetMapping("/getOrder")
    public ResponseEntity<?> getOrderById(@RequestParam  int id){

        Optional<OrderEntity> orderEntity= orderService.findOrder(id);

        if( orderEntity.isEmpty()){
                String body="This is invalid order id";
            return new ResponseEntity<>(body , HttpStatus.OK);
        }else{
            OrderDto orderDto =  orderMapper.toDto(orderEntity.get());
           /*
           // using map struct
           OrderDto orderDto = orderMappper.mapTo(orderEntity.get());

            */
            return new ResponseEntity<>(orderDto , HttpStatus.OK);
        }

    }

    @GetMapping("/getResponsibleEmployee")
    public ResponseEntity<?> getResponsibleEmployee(@RequestParam int orderId){

       EmployeeEntity employeeEntity = orderService.findEmployeeResponsibleOrder(orderId);
       if (employeeEntity == null){
           String body = "This is invalid order id";
           return new ResponseEntity<>(body , HttpStatus.BAD_REQUEST);

        }else {
           EmployeeDto employeeDto =  employeeMapper.toDto(employeeEntity);
           /*
           // using map struct
          EmployeeDto employeeDto = employeeMapper.mapTo(employeeEntity);

            */
           return new ResponseEntity<>(employeeDto , HttpStatus.OK);

       }

    }
}
