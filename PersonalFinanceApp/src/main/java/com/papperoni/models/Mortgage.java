package com.papperoni.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Mortgages")
public class Mortgage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mortgageId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private OwnerOfAccount owner;

    private String accountIdentifier;
    private String accountName;
    private BigDecimal balance;
    private Integer paymentDate;
    private BigDecimal minMonthlyPayment;
    private Boolean autoPay;
    private String fromAccount;
    private LocalDate updated;
    private BigDecimal apr;
    private LocalDateTime createdAt;
    private String notes;
}
