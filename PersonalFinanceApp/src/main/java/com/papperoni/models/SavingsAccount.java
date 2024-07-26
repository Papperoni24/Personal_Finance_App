package com.papperoni.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SavingsAccounts")
public class SavingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingsId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private OwnerOfAccount owner;

    private String accountIdentifier;
    private String accountName;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private String notes;
}
