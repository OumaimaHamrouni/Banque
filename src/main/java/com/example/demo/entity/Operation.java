package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)

public class Operation  {



public Operation(Date dateOperation, double montant, Compte compte) {
    this.dateOperation = dateOperation;
    this.montant = montant;
    this.compte = compte;
}

	
@Id
@NonNull
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long numeroOperation;

private Date dateOperation; private double montant;

@ManyToOne
@JoinColumn(name="Code_CPT") private Compte compte;

@ManyToOne

@JoinColumn(name="Code_Employe") 
private Employes employe ;
}

