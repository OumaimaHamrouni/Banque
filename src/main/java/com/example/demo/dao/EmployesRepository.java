package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Employes;
import com.example.demo.entity.Groupe;

@RepositoryRestResource(collectionResourceRel = "employeé", path="employeé")
public interface EmployesRepository extends JpaRepository<Employes, Long> {
	

}
