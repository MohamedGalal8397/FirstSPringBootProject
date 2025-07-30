package com.Mohamed.SpringDataProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Mohamed.SpringDataProject.model.entity.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
}
