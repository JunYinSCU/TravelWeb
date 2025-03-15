package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.service.OrderService;
import com.entity.OrderEntity;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<OrderEntity> getHistoryOrders(Long userId) {
        // Temporary mock data
        List<OrderEntity> historyOrders = new ArrayList<>();

        OrderEntity order1 = new OrderEntity();
        order1.setJingdianmingcheng("北京2日游");
        order1.setGoupiaoshijian(LocalDateTime.parse("2024-12-01T10:00:00"));
        order1.setZongjine(new BigDecimal("15000"));
        order1.setStatus("history");

        OrderEntity order2 = new OrderEntity();
        order2.setJingdianmingcheng("巴黎行");
        order2.setGoupiaoshijian(LocalDateTime.parse("2024-11-20T15:30:00"));
        order2.setZongjine(new BigDecimal("53350"));
        order2.setStatus("history");

        historyOrders.add(order1);
        historyOrders.add(order2);

        return historyOrders;
    }

    @Override
    public List<OrderEntity> getCurrentOrders(Long userId) {
        // Temporary mock data
        List<OrderEntity> currentOrders = new ArrayList<>();

        OrderEntity order1 = new OrderEntity();
        order1.setJingdianmingcheng("重庆一日游");
        order1.setGoupiaoshijian(LocalDateTime.parse("2024-12-31T10:00:00"));
        order1.setZongjine(new BigDecimal("1200"));
        order1.setStatus("current");

        OrderEntity order2 = new OrderEntity();
        order2.setJingdianmingcheng("新疆阿勒泰");
        order2.setGoupiaoshijian(LocalDateTime.parse("2025-02-05T16:00:00"));
        order2.setZongjine(new BigDecimal("1080"));
        order2.setStatus("current");

        currentOrders.add(order1);
        currentOrders.add(order2);

        return currentOrders;
    }
}
