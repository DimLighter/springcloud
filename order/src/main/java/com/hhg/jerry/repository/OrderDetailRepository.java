package com.hhg.jerry.repository;

import com.hhg.jerry.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lina on 2018/10/12.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
