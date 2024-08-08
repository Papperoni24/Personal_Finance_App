package com.papperoni.services.impl;

import com.papperoni.models.CreditCard;
import com.papperoni.repositories.CreditCardRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CreditCardServiceImplTest {

    @Mock
    private CreditCardRepo creditCardRepo;

    @InjectMocks
    private CreditCardServiceImpl creditCardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        CreditCard card1 = new CreditCard();
        CreditCard card2 = new CreditCard();
        List<CreditCard> creditCards = Arrays.asList(card1, card2);

        when(creditCardRepo.findAll()).thenReturn(creditCards);

        List<CreditCard> result = creditCardService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(creditCardRepo, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardId(id);

        when(creditCardRepo.findById(id)).thenReturn(Optional.of(creditCard));

        CreditCard result = creditCardService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getCreditCardId());
        verify(creditCardRepo, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        Long id = 2L;

        when(creditCardRepo.findById(id)).thenReturn(Optional.empty());

        CreditCard result = creditCardService.findById(id);

        assertNull(result);
        verify(creditCardRepo, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        CreditCard creditCard = new CreditCard();
        when(creditCardRepo.save(any(CreditCard.class))).thenReturn(creditCard);

        CreditCard result = creditCardService.save(creditCard);

        assertNotNull(result);
        verify(creditCardRepo, times(1)).save(creditCard);
    }

    @Test
    public void testDeleteById() {
        Long id = 3L;

        creditCardService.deleteById(id);

        verify(creditCardRepo, times(1)).deleteById(id);
    }
}

