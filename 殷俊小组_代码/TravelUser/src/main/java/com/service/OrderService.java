package com.service;

import com.entity.OrderEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import com.entity.OrderEntity;

public interface OrderService {
    List<OrderEntity> getHistoryOrders(Long userId);
    List<OrderEntity> getCurrentOrders(Long userId);
}