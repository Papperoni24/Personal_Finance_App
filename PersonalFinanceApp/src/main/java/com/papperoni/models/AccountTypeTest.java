package com.papperoni.models;

import org.testng.annotations.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTypeTest {

    @Test
    void testDefaultConstructor() {
        AccountType accountType = new AccountType();
        assertNotNull(accountType);
    }

    @Test
    void testParameterizedConstructor() {
        AccountType accountType = new AccountType("Savings", "Personal savings account");
        assertEquals("Savings", accountType.getAccountTypeName());
        assertEquals("Personal savings account", accountType.getNotes());
    }

    @Test
    void testGettersAndSetters() {
        AccountType accountType = new AccountType();
        accountType.setAccountTypeID(1);
        accountType.setAccountTypeName("Checking");
        accountType.setNotes("Personal checking account");

        assertEquals(1, accountType.getAccountTypeID());
        assertEquals("Checking", accountType.getAccountTypeName());
        assertEquals("Personal checking account", accountType.getNotes());
    }

    @Test
    void testToString() {
        AccountType accountType = new AccountType("Investment", "Investment account");
        accountType.setAccountTypeID(2);

        String expected = "AccountType{" +
                "accountTypeID=2" +
                ", accountTypeName='Investment'" +
                ", notes='Investment account'" +
                '}';

        assertEquals(expected, accountType.toString());
    }

    @Test
    void testEquals() {
        AccountType accountType1 = new AccountType("Business", "Business account");
        accountType1.setAccountTypeID(3);

        AccountType accountType2 = new AccountType("Business", "Business account");
        accountType2.setAccountTypeID(3);

        AccountType accountType3 = new AccountType("Personal", "Personal account");
        accountType3.setAccountTypeID(4);

        assertEquals(accountType1, accountType2);
        assertNotEquals(accountType1, accountType3);
        assertNotEquals(accountType2, accountType3);
        assertNotEquals(accountType1, null);
        assertNotEquals(accountType1, new Object());
    }

    @Test
    void testHashCode() {
        AccountType accountType1 = new AccountType("Retirement", "Retirement savings");
        accountType1.setAccountTypeID(5);

        AccountType accountType2 = new AccountType("Retirement", "Retirement savings");
        accountType2.setAccountTypeID(5);

        assertEquals(accountType1.hashCode(), accountType2.hashCode());
    }
}

