package com.papperoni.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CreditCards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private OwnerOfAccount owner;

    private String accountIdentifier;
    private String accountName;
    private BigDecimal creditLimit;
    private BigDecimal balance;
    private Integer paymentDate;
    private BigDecimal minMonthlyPayment;
    private Boolean autoPay;
    private String fromAccount;
    private LocalDate updated;
    private BigDecimal apr;
    private BigDecimal annualFee;
    private LocalDateTime createdAt;
    private String notes;
}

