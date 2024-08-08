package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "StudentLoans")
public class StudentLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentLoanID")
    private Long studentLoanId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    @NotNull(message = "Owner is required")
    private int ownerID;

    @NotBlank(message = "Account identifier is required")
    @Size(max = 100, message = "Account identifier cannot exceed 100 characters")
    @Column(name = "AccountIdentifier", length = 100, nullable = false)
    private String accountIdentifier;

    @Size(max = 100, message = "Account name cannot exceed 100 characters")
    @Column(name = "AccountName", length = 100)
    private String accountName;

    @NotNull(message = "Balance must be specified")
    @PositiveOrZero(message = "Balance must be zero or positive")
    @Column(name = "Balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal balance;

    @Column(name = "PaymentDate")
    private Integer paymentDate;

    @Column(name = "MinMonthlyPayment", precision = 15, scale = 2)
    private BigDecimal minMonthlyPayment;

    @Column(name = "AutoPay", nullable = false)
    private Boolean autoPay;

    @Column(name = "DefaultPayment")
    private int defaultPaymentID;

    @NotNull(message = "Updated date is required")
    @Column(name = "Updated", nullable = false)
    private LocalDate updated;

    @Column(name = "APR", precision = 5, scale = 2)
    private BigDecimal apr;

    @NotNull(message = "Creation date is required")
    @Column(name = "CreatedAt", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    @Column(name = "Notes", length = 255)
    private String notes;

    public StudentLoan() {
    }

    public StudentLoan(Long studentLoanId, int ownerID, String accountIdentifier, BigDecimal balance, String accountName, Integer paymentDate, BigDecimal minMonthlyPayment, Boolean autoPay, int defaultPaymentID, LocalDate updated, BigDecimal apr, LocalDateTime createdAt, String notes) {
        this.studentLoanId = studentLoanId;
        this.ownerID = ownerID;
        this.accountIdentifier = accountIdentifier;
        this.balance = balance;
        this.accountName = accountName;
        this.paymentDate = paymentDate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.autoPay = autoPay;
        this.defaultPaymentID = defaultPaymentID;
        this.updated = updated;
        this.apr = apr;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getStudentLoanId() {
        return studentLoanId;
    }

    public void setStudentLoanId(Long studentLoanId) {
        this.studentLoanId = studentLoanId;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Integer paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getMinMonthlyPayment() {
        return minMonthlyPayment;
    }

    public void setMinMonthlyPayment(BigDecimal minMonthlyPayment) {
        this.minMonthlyPayment = minMonthlyPayment;
    }

    public Boolean getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(Boolean autoPay) {
        this.autoPay = autoPay;
    }

    public int getDefaultPaymentID() {
        return defaultPaymentID;
    }

    public void setDefaultPaymentID(int defaultPaymentID) {
        this.defaultPaymentID = defaultPaymentID;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public BigDecimal getApr() {
        return apr;
    }

    public void setApr(BigDecimal apr) {
        this.apr = apr;
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
        StudentLoan that = (StudentLoan) o;
        return Objects.equals(studentLoanId, that.studentLoanId) &&
                Objects.equals(ownerID, that.ownerID) &&
                Objects.equals(accountIdentifier, that.accountIdentifier) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(minMonthlyPayment, that.minMonthlyPayment) &&
                Objects.equals(autoPay, that.autoPay) &&
                Objects.equals(defaultPaymentID, that.defaultPaymentID) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(apr, that.apr) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentLoanId, ownerID, accountIdentifier, accountName, balance, paymentDate, minMonthlyPayment, autoPay, defaultPaymentID, updated, apr, createdAt, notes);
    }

    @Override
    public String toString() {
        return "StudentLoan{" +
                "studentLoanId=" + studentLoanId +
                ", ownerID=" + ownerID +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", minMonthlyPayment=" + minMonthlyPayment +
                ", autoPay=" + autoPay +
                ", defaultPaymentID=" + defaultPaymentID +
                ", updated=" + updated +
                ", apr=" + apr +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
