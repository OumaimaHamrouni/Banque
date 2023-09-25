package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "TypeCpt",discriminatorType = DiscriminatorType.STRING,length = 2)

public abstract class Compte {
@Id
@NonNull

private String CodeCompte;

private Date dateCreation;
private double solde ;


@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="code_Cli")
private Client client;

@ManyToOne
@JoinColumn(name="Code_Emp")
private Employes employe;
@OneToMany( mappedBy="compte",cascade = CascadeType.ALL)
private Collection<Operation> operations;
}
