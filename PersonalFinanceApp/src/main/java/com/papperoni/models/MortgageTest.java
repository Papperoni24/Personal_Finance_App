package com.papperoni.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MortgageTest {

    @Test
    void testDefaultConstructor() {
        Mortgage mortgage = new Mortgage();
        assertNotNull(mortgage);
    }

    @Test
    void testParameterizedConstructor() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        Mortgage mortgage = new Mortgage(
                1L,
                owner,
                "123-456-789",
                "Home Loan",
                new BigDecimal("200000.00"),
                15,
                new BigDecimal("1500.00"),
                true,
                "Credit Card",
                today,
                new BigDecimal("3.50"),
                now,
                "Main home mortgage"
        );

        assertEquals(1L, mortgage.getMortgageId());
        assertEquals(owner, mortgage.getOwner());
        assertEquals("123-456-789", mortgage.getAccountIdentifier());
        assertEquals("Home Loan", mortgage.getAccountName());
        assertEquals(new BigDecimal("200000.00"), mortgage.getBalance());
        assertEquals(15, mortgage.getPaymentDate());
        assertEquals(new BigDecimal("1500.00"), mortgage.getMinMonthlyPayment());
        assertTrue(mortgage.getAutoPay());
        assertEquals("Credit Card", mortgage.getDefaultPayment());
        assertEquals(today, mortgage.getUpdated());
        assertEquals(new BigDecimal("3.50"), mortgage.getApr());
        assertEquals(now, mortgage.getCreatedAt());
        assertEquals("Main home mortgage", mortgage.getNotes());
    }

    @Test
    void testGettersAndSetters() {
        Mortgage mortgage = new Mortgage();
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        mortgage.setMortgageId(2L);
        mortgage.setOwner(owner);
        mortgage.setAccountIdentifier("987-654-321");
        mortgage.setAccountName("Second Home Loan");
        mortgage.setBalance(new BigDecimal("300000.00"));
        mortgage.setPaymentDate(20);
        mortgage.setMinMonthlyPayment(new BigDecimal("2000.00"));
        mortgage.setAutoPay(false);
        mortgage.setDefaultPayment("Bank Transfer");
        mortgage.setUpdated(today);
        mortgage.setApr(new BigDecimal("4.00"));
        mortgage.setCreatedAt(now);
        mortgage.setNotes("Second home mortgage");

        assertEquals(2L, mortgage.getMortgageId());
        assertEquals(owner, mortgage.getOwner());
        assertEquals("987-654-321", mortgage.getAccountIdentifier());
        assertEquals("Second Home Loan", mortgage.getAccountName());
        assertEquals(new BigDecimal("300000.00"), mortgage.getBalance());
        assertEquals(20, mortgage.getPaymentDate());
        assertEquals(new BigDecimal("2000.00"), mortgage.getMinMonthlyPayment());
        assertFalse(mortgage.getAutoPay());
        assertEquals("Bank Transfer", mortgage.getDefaultPayment());
        assertEquals(today, mortgage.getUpdated());
        assertEquals(new BigDecimal("4.00"), mortgage.getApr());
        assertEquals(now, mortgage.getCreatedAt());
        assertEquals("Second home mortgage", mortgage.getNotes());
    }

    @Test
    void testToString() {
        OwnerOfAccount owner = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        Mortgage mortgage = new Mortgage(
                1L,
                owner,
                "123-456-789",
                "Home Loan",
                new BigDecimal("200000.00"),
                15,
                new BigDecimal("1500.00"),
                true,
                "Credit Card",
                today,
                new BigDecimal("3.50"),
                now,
                "Main home mortgage"
        );

        String expected = "Mortgage{" +
                "mortgageId=1" +
                ", owner=" + owner +
                ", accountIdentifier='123-456-789'" +
                ", accountName='Home Loan'" +
                ", balance=200000.00" +
                ", paymentDate=15" +
                ", minMonthlyPayment=1500.00" +
                ", autoPay=true" +
                ", defaultPayment='Credit Card'" +
                ", updated=" + today +
                ", apr=3.50" +
                ", createdAt=" + now +
                ", notes='Main home mortgage'" +
                '}';

        assertEquals(expected, mortgage.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        OwnerOfAccount owner1 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        OwnerOfAccount owner2 = new OwnerOfAccount(); // Assume OwnerOfAccount has a default constructor or use a mock
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        Mortgage mortgage1 = new Mortgage(
                1L,
                owner1,
                "123-456-789",
                "Home Loan",
                new BigDecimal("200000.00"),
                15,
                new BigDecimal("1500.00"),
                true,
                "Credit Card",
                today,
                new BigDecimal("3.50"),
                now,
                "Main home mortgage"
        );

        Mortgage mortgage2 = new Mortgage(
                1L,
                owner1,
                "123-456-789",
                "Home Loan",
                new BigDecimal("200000.00"),
                15,
                new BigDecimal("1500.00"),
                true,
                "Credit Card",
                today,
                new BigDecimal("3.50"),
                now,
                "Main home mortgage"
        );

        Mortgage mortgage3 = new Mortgage(
                2L,
                owner2,
                "987-654-321",
                "Second Home Loan",
                new BigDecimal("300000.00"),
                20,
                new BigDecimal("2000.00"),
                false,
                "Bank Transfer",
                today,
                new BigDecimal("4.00"),
                now,
                "Second home mortgage"
        );

        assertEquals(mortgage1, mortgage2);
        assertNotEquals(mortgage1, mortgage3);
        assertNotEquals(mortgage2, mortgage3);
        assertNotEquals(mortgage1, null);
        assertNotEquals(mortgage1, new Object());

        assertEquals(mortgage1.hashCode(), mortgage2.hashCode());
        assertNotEquals(mortgage1.hashCode(), mortgage3.hashCode());
    }
}
