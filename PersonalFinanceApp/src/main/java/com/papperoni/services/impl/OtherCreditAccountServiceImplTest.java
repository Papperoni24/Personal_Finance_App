package com.papperoni.services.impl;

import com.papperoni.models.OtherCreditAccount;
import com.papperoni.repositories.OtherCreditAccountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class OtherCreditAccountServiceImplTest {

    @Mock
    private OtherCreditAccountRepo otherCreditAccountRepository;

    @InjectMocks
    private OtherCreditAccountServiceImpl otherCreditAccountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOtherCreditAccounts() {
        OtherCreditAccount account1 = new OtherCreditAccount();
        OtherCreditAccount account2 = new OtherCreditAccount();
        List<OtherCreditAccount> accounts = Arrays.asList(account1, account2);

        when(otherCreditAccountRepository.findAll()).thenReturn(accounts);

        List<OtherCreditAccount> result = otherCreditAccountService.getAllOtherCreditAccounts();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(otherCreditAccountRepository).findAll();
    }

    @Test
    public void testGetOtherCreditAccountById() {
        Long id = 1L;
        OtherCreditAccount account = new OtherCreditAccount();
        when(otherCreditAccountRepository.findById(id)).thenReturn(Optional.of(account));

        Optional<OtherCreditAccount> result = otherCreditAccountService.getOtherCreditAccountById(id);

        assertTrue(result.isPresent());
        assertEquals(account, result.get());
        verify(otherCreditAccountRepository).findById(id);
    }

    @Test
    public void testGetOtherCreditAccountByIdNotFound() {
        Long id = 1L;
        when(otherCreditAccountRepository.findById(id)).thenReturn(Optional.empty());

        Optional<OtherCreditAccount> result = otherCreditAccountService.getOtherCreditAccountById(id);

        assertFalse(result.isPresent());
        verify(otherCreditAccountRepository).findById(id);
    }

    @Test
    public void testSaveOtherCreditAccount() {
        OtherCreditAccount account = new OtherCreditAccount();
        when(otherCreditAccountRepository.save(account)).thenReturn(account);

        OtherCreditAccount result = otherCreditAccountService.saveOtherCreditAccount(account);

        assertNotNull(result);
        verify(otherCreditAccountRepository).save(account);
    }

    @Test
    public void testDeleteOtherCreditAccount() {
        Long id = 1L;

        doNothing().when(otherCreditAccountRepository).deleteById(id);

        otherCreditAccountService.deleteOtherCreditAccount(id);

        verify(otherCreditAccountRepository).deleteById(id);
    }

    @Test
    public void testUpdateOtherCreditAccount() {
        Long id = 1L;
        OtherCreditAccount existingAccount = new OtherCreditAccount();
        OtherCreditAccount accountDetails = new OtherCreditAccount();

        // Setting up the updated details
        accountDetails.setOwnerID(5);
        accountDetails.setAccountIdentifier("New Identifier");
        accountDetails.setAccountName("New Name");
        accountDetails.setCreditLimit(BigDecimal.valueOf(5000));
        accountDetails.setBalance(BigDecimal.valueOf(2500));
        accountDetails.setPaymentDate(15);
        accountDetails.setMinMonthlyPayment(BigDecimal.valueOf(100));
        accountDetails.setAutoPay(true);
        accountDetails.setDefaultPaymentID(9);
        accountDetails.setUpdated(LocalDate.now());
        accountDetails.setApr(BigDecimal.valueOf(3.5));
        accountDetails.setAnnualFee(BigDecimal.valueOf(100));
        accountDetails.setCreatedAt(LocalDateTime.now());
        accountDetails.setNotes("Updated notes");

        when(otherCreditAccountRepository.findById(id)).thenReturn(Optional.of(existingAccount));
        when(otherCreditAccountRepository.save(any(OtherCreditAccount.class))).thenReturn(accountDetails);

        OtherCreditAccount result = otherCreditAccountService.updateOtherCreditAccount(id, accountDetails);

        assertNotNull(result);
        assertEquals(5, result.getOwnerID());
        assertEquals("New Identifier", result.getAccountIdentifier());
        assertEquals("New Name", result.getAccountName());
        assertEquals(BigDecimal.valueOf(5000), result.getCreditLimit());
        assertEquals(BigDecimal.valueOf(2500), result.getBalance());
        assertEquals(15, result.getPaymentDate());
        assertEquals(BigDecimal.valueOf(100), result.getMinMonthlyPayment());
        assertTrue(result.getAutoPay());
        assertEquals(9, result.getDefaultPaymentID());
        assertEquals(LocalDate.now(), result.getUpdated());
        assertEquals(BigDecimal.valueOf(3.5), result.getApr());
        assertEquals(BigDecimal.valueOf(100), result.getAnnualFee());
        assertNotNull(result.getCreatedAt());
        assertEquals("Updated notes", result.getNotes());
        verify(otherCreditAccountRepository).findById(id);
        verify(otherCreditAccountRepository).save(any(OtherCreditAccount.class));
    }

    @Test
    public void testUpdateOtherCreditAccountNotFound() {
        Long id = 1L;
        OtherCreditAccount accountDetails = new OtherCreditAccount();

        when(otherCreditAccountRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            otherCreditAccountService.updateOtherCreditAccount(id, accountDetails);
        });

        assertEquals("OtherCreditAccount not found", thrown.getMessage());
        verify(otherCreditAccountRepository).findById(id);
        verify(otherCreditAccountRepository, never()).save(any(OtherCreditAccount.class));
    }
}
