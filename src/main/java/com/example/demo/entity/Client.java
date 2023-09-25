package com.example.demo.entity;

import java.util.Collection;


import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import lombok.*;


@AllArgsConstructor
@Data
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="codeClient")
@Entity
@RequiredArgsConstructor

public class Client {

	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long codeClient;
private String nomClient;

@OneToMany(mappedBy="client",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
private Collection<Compte>comptes;


	
}
