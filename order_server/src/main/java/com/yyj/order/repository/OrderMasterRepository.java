package com.yyj.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyj.order.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String>{

}
