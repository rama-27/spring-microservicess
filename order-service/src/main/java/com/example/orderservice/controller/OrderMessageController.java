package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/orders")
@RefreshScope
public class OrderMessageController {

    @Value("${order.message:Default Order Service Message (fallback)}")
    private String orderMessage;

    @Value("${order.discount:0.0}")
    private double discount;

    @GetMapping("/config")
    public ResponseEntity<Map<String, Object>> getDynamicConfig() {
        return ResponseEntity.ok(Map.of(
                "orderMessage", orderMessage,
                "discount", discount
        ));
    }
}
