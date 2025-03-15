package com.controller;

import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.service.OrderService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Get historical orders
     */
    @RequestMapping("/history")
    public R getHistoryOrders(HttpServletRequest request) {
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            Long userId = (Long) request.getSession().getAttribute("userId");
            return R.ok().put("data", orderService.getHistoryOrders(userId));
        }
        return R.ok().put("data", orderService.getHistoryOrders(null));
    }

    /**
     * Get current orders
     */
    @RequestMapping("/current")
    public R getCurrentOrders(HttpServletRequest request) {
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            Long userId = (Long) request.getSession().getAttribute("userId");
            return R.ok().put("data", orderService.getCurrentOrders(userId));
        }
        return R.ok().put("data", orderService.getCurrentOrders(null));
    }
}