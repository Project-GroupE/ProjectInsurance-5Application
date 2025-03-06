/*
 * add your task as well as functionality here
 */

package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Payment;
import com.example.service.PaymentService;

// All RestAPIs are centralized into below restController class

@RestController
@RequestMapping("/payments")
public class PaymentRestController {
	//Added By Namrata for task saving a payment
	@Autowired
    private PaymentService paymentService;

	//http://localhost:8181/payments/save?policyId=102&amount=5025&paymethod=cheque
    @PostMapping("/save")
    public ResponseEntity<Payment> savePayment(@RequestParam Long policyId, @RequestParam Double amount,@RequestParam String paymethod) {
        Payment payment = paymentService.savePayment(policyId, amount,paymethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
