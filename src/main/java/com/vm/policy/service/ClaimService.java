package com.vm.policy.service;

import com.vm.policy.model.Claim;

import java.util.List;

public interface ClaimService {
    Claim createClaim(Claim claim);
    List<Claim> getAllClaims();
    Claim getClaimById(Long id);
    List<Claim> getClaimsByPolicyId(Long policyId);
}
