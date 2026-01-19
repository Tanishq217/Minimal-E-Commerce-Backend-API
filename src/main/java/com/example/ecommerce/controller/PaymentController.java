package com.example.ecommerce.controller;

import com.example.ecommerce.dto.PaymentRequest;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest request) {
        try {
            Payment payment = paymentService.createPayment(request.getOrderId(), request.getAmount());
            return ResponseEntity.ok(payment);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Payment Error: " + e.getMessage());
        }
    }
}