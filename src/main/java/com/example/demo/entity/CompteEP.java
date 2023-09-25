package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@Data

@Entity
@RequiredArgsConstructor
@DiscriminatorValue("EP")
public class CompteEP extends Compte {
	private double taux;

}
