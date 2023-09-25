package com.example.demo.Services;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Compte;
import com.example.demo.entity.Operation;

import java.util.Optional;

public interface OperationService {

    public Optional<Compte> consulterCompter(String codeCpte);
    public void verser(String codeCpte , double montant);
    public void reterait(String codeCpte , double montant);
    public void verement(String codeCpte1 , String codeCpte2 , double montant);
    public Page<Operation> listOperation(String codeCpte , int page , int size);
    Optional<Compte> findById(String id);

}