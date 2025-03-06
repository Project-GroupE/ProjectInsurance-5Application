/*
 * add your task as well as functionality here
 */

package com.example.implementation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Payment;
import com.example.entity.Policy;
import com.example.repository.PaymentRepository;
import com.example.repository.PolicyRepository;
import com.example.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PolicyRepository policyRepository;

    public Payment savePayment(Long policyId, Double amount,String paymethod) {
        // Fetch the policy from DB
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        // Check if policy is ACTIVE
        if (!"ACTIVE".equalsIgnoreCase(policy.getPolicyStatus())) {
            throw new RuntimeException("Payment cannot be processed as policy is not active");
        }

        // Save the payment
        Payment payment = new Payment();
        payment.setPolicy(policy);
        payment.setAmountPaid(amount);
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentStatus("SUCCESS");
        payment.setPaymentMethod(paymethod);

        return paymentRepository.save(payment);
    }
}
