package com.papperoni.controllers;

import com.papperoni.models.CreditCard;
import com.papperoni.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {

    private final CreditCardService service;

    @Autowired
    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CreditCard getCreditCardById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CreditCard createCreditCard(@RequestBody CreditCard creditCard) {
        return service.save(creditCard);
    }

    @PutMapping("/{id}")
    public CreditCard updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        creditCard.setCreditCardId(id);
        return service.save(creditCard);
    }

    @DeleteMapping("/{id}")
    public void deleteCreditCard(@PathVariable Long id) {
        service.deleteById(id);
    }
}
