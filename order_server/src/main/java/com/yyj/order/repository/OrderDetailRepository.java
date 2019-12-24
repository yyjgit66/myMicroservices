package com.yyj.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyj.order.dataobject.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

}
