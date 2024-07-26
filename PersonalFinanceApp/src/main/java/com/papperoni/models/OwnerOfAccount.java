package com.papperoni.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public OwnerOfAccount() {
    }

    public OwnerOfAccount(Long ownerId, String username, String email, LocalDateTime createdAt, String notes) {
        this.ownerId = ownerId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerOfAccount that = (OwnerOfAccount) o;
        return Objects.equals(ownerId, that.ownerId) && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, username, email, createdAt, notes);
    }

    @Override
    public String toString() {
        return "OwnerOfAccount{" +
                "ownerId=" + ownerId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
