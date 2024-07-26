package com.papperoni.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "OwnerOfAccounts")
public class OwnerOfAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    private String username;
    private String email;
    private LocalDateTime createdAt;
    private String notes;
}
