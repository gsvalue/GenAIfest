package com.vm.policy.controller;

import com.vm.policy.model.Policy;
import com.vm.policy.model.User;
import com.vm.policy.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPolicy(@RequestBody Policy policy) {
        policyService.createPolicy(policy);
        return ResponseEntity.status(201).body("Policy created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(policy);
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        return ResponseEntity.ok(policies);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Policy>> getPoliciesByUser(@PathVariable Long userId) {
        List<Policy> policies = policyService.getPoliciesByUser(userId);
        return ResponseEntity.ok(policies);
    }

    @GetMapping("/{policyId}/details")
    public ResponseEntity<Policy> getPolicyWithClaims(@PathVariable Long policyId) {
        Policy policy = policyService.getPolicyWithClaims(policyId);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(policy);
    }

}
