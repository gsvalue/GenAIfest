package com.vm.policy.controller;

import com.vm.policy.model.Claim;
import com.vm.policy.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/create")
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim created = claimService.createClaim(claim);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Claim claim = claimService.getClaimById(id);
        if (claim == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(claim);
    }

    @GetMapping("/policy/{policyId}")
    public ResponseEntity<List<Claim>> getClaimsByPolicy(@PathVariable Long policyId) {
        List<Claim> claims = claimService.getClaimsByPolicyId(policyId);
        return ResponseEntity.ok(claims);
    }
}
