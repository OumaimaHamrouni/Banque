package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.CompteEP;

@RepositoryRestResource(collectionResourceRel = "CompteEp", path="CompteEp")
public interface CompteEPRepository  extends JpaRepository<CompteEP,String>{

}
