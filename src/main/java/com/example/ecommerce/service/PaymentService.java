package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.PaymentRepository;

// ADD THESE IMPORTS
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ... rest of your code ...

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    // You can put these in application.properties later
    private String keyId = "rzp_test_YOUR_KEY_HERE";
    private String keySecret = "YOUR_SECRET_HERE";

    public Payment createPayment(String orderId, Double amount) throws RazorpayException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Initialize Razorpay
        RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);

        // Create Request
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Amount in paisa
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_rcptid_" + orderId);

        // Call Razorpay API
        com.razorpay.Order razorpayOrder = razorpay.orders.create(orderRequest);
        String razorpayOrderId = razorpayOrder.get("id");

        // Save Payment details locally
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setPaymentId(razorpayOrderId);
        payment.setStatus("PENDING");

        return paymentRepository.save(payment);
    }
}