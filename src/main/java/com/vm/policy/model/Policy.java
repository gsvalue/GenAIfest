package com.vm.policy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String policyType;
    private Double coverageAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key to the User table
    private User user;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Claim> claims;

}
