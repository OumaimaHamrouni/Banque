package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Compte;


@RepositoryRestResource(collectionResourceRel = "Compte", path="Compte")
public interface CompteRepository extends JpaRepository<Compte, String> {

}
