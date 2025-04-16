package com.vm.policy.service.impl;

import com.vm.policy.model.Policy;
import com.vm.policy.repository.PolicyRepository;
import com.vm.policy.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public void createPolicy(Policy policy) {
        policyRepository.save(policy);
    }

    @Override
    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);  // Return null if not found
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        return List.of();
    }

   /* @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepository.findAllByUserId(userId); // You may need to add this method to the repository
    }*/

    @Override
    public Policy getPolicyWithClaims(Long policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }



}
