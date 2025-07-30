package com.Mohamed.SpringDataProject.repository;


import com.Mohamed.SpringDataProject.EmployeeData;
import com.Mohamed.SpringDataProject.Repository.EmployeeRepository;
import com.Mohamed.SpringDataProject.model.entity.EmployeeEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class EmployeeEntityReposiyoryTest {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeEntityReposiyoryTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Test
    @DisplayName("Test of saving and finding Employee Method")
    public void saveEmployeeRepositoryTest(){
        EmployeeEntity employeeEntity =  EmployeeData.getEmployeeTest();
        employeeRepository.save(employeeEntity);
      Optional<EmployeeEntity> emp= employeeRepository.findById(employeeEntity.getId());

        assertThat(emp).isPresent();

        assertThat(emp.get()).isEqualTo(employeeEntity);

    }

    @Test
    @DisplayName("Test of finding All Employee Method")

    public void findAllEmployeeRepositoryTest(){
      List<EmployeeEntity> employeeEntityList =employeeRepository.findAll();
        assertThat(employeeEntityList).isNotEmpty();

    }

    @Test
    @DisplayName("Test Updating Employee Data")
    public void updateEmployeeRepositoryTest(){
        EmployeeEntity employeeEntity = EmployeeData.updateEmployeeTest();
         // employeeRepository.save() is used for both saving and updating depends on id has value or not
       EmployeeEntity emp = employeeRepository.save(employeeEntity);
       assertThat(emp).isEqualTo(employeeEntity);

    }

    @Test
    @DisplayName("Test Deleting Employee")
    public void deleteEmployeeRepositoryTest(){
        EmployeeEntity employeeEntity = EmployeeData.updateEmployeeTest();
        employeeRepository.deleteById(employeeEntity.getId());
        Optional<EmployeeEntity> emp = employeeRepository.findById(employeeEntity.getId());
        assertThat(emp).isEqualTo(Optional.empty());

    }

   /* @Test
    @DisplayName("Test Find by title")
    public void findEmployeeByTittleRepositoryTest(){

       String title ="Developer";
       EmployeeEntity employeeEntity = employeeRepository.findEmployeeByTitle(title);
       assertThat(employeeEntity.getTitle()).isEqualTo("Developer");
    }

    */


  /*  @Test
    @DisplayName("Test find by first name HQL")
    public void findEmployeeByFirstNameRepositoryTest(){
        String name ="User";
       EmployeeEntity emp = employeeRepository.findEmployeeByFirstName(name);
       assertThat(emp).isNotNull();
       assertThat(emp.getFirstName()).isEqualTo(name);

    }


   */


}
