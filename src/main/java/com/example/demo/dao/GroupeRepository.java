package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Client;
import com.example.demo.entity.Groupe;

@RepositoryRestResource(collectionResourceRel = "groupe", path="Groupe")
public interface GroupeRepository extends JpaRepository<Groupe, Long>{

}
