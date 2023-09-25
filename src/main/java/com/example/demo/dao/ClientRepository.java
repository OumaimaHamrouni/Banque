package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Client;

@RepositoryRestResource(collectionResourceRel = "client", path="Clients")
public interface ClientRepository extends JpaRepository<Client, Long> {
	

}
