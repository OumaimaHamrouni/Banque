package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="codeGroupe")
@RequiredArgsConstructor

@Table(name="Groupes")
public class Groupe {
	@Id 
	@NonNull
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long codeGroupe ;
	
	private  String nomGroupe ;
	
	@RestResource(exported = false)
	@ManyToMany(mappedBy = "groupes",fetch = FetchType.LAZY)
	
	private Collection <Employes> employes ;
}
