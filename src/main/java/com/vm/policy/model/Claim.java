package com.vm.policy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;
    private LocalDate claimDate;
    private Double claimAmount;
    private String status;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
}
