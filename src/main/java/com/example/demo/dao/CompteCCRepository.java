package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.CompteCC;


@RepositoryRestResource(collectionResourceRel = "CompteCC", path="CompteCC")
public interface CompteCCRepository extends JpaRepository<CompteCC, String>{

}
