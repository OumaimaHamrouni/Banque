package com.example.demo.entity;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue("R")
@Data
public class Retrait extends Operation{
	public Retrait() {
        super();
    }

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

}
