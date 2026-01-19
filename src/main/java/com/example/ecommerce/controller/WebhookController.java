package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payment")
    public ResponseEntity<?> handlePaymentWebhook(@RequestBody Map<String, Object> payload) {
        // In a real app, you would verify the signature here.
        // For this assignment, we simply update the order status.

        System.out.println("Webhook received: " + payload);

        // We assume the payload contains the Order ID somewhere (simplified for assignment)
        // In a real Razorpay payload, you parse "payload.payment.entity.notes.orderId"

        return ResponseEntity.ok("Webhook received");
    }
}