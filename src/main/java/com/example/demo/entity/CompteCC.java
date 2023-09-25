package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@Data

@Entity
@RequiredArgsConstructor
@DiscriminatorValue("cc")

public class CompteCC extends Compte {

	private double decouvert;
}
