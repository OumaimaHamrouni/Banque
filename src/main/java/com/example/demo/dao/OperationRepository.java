package com.example.demo.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Operation;
@RepositoryRestResource(collectionResourceRel = "operation", path="Operation")
public interface OperationRepository extends JpaRepository<Operation,Long> {

    @Query("select o from Operation o where o.compte.CodeCompte=:x order by  o.dateOperation desc ")
    public Page<Operation> listOperatiion(@Param("x") String CodeCompte , Pageable pageable );


}