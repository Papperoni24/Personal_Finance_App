package com.papperoni.controllers;

import com.papperoni.models.OwnerOfAccount;
import com.papperoni.services.OwnerOfAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerOfAccountsController {

    private final OwnerOfAccountsService service;

    @Autowired
    public OwnerOfAccountsController(OwnerOfAccountsService service) {
        this.service = service;
    }

    @GetMapping
    public List<OwnerOfAccount> getAllOwners() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OwnerOfAccount getOwnerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public OwnerOfAccount createOwner(@RequestBody OwnerOfAccount owner) {
        return service.save(owner);
    }

    @PutMapping("/{id}")
    public OwnerOfAccount updateOwner(@PathVariable Long id, @RequestBody OwnerOfAccount owner) {
        owner.setOwnerId(id);
        return service.save(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        service.deleteById(id);
    }
}
