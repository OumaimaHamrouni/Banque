package com.example.demo.Services;

import java.util.List;


import com.example.demo.entity.CompteCC;
import com.example.demo.entity.CompteEP;

public interface CompteService {
	//---------------------------------------------CompteCC--------------------------
	CompteCC saveComptecc(CompteCC comptecc);
	void deleteComptecc(CompteCC comptecc);
	void deleteCompteccById(String id);
	CompteCC getComptecc(String id);
	List<CompteCC> getAllComptescc();
	
	//---------------------------------------------CompteEP--------------------------
	CompteEP saveCompteep(CompteEP compteep);
	void deleteCompteep(CompteEP compteep);
	void deleteCompteepById(String id);
	CompteEP getCompteep(String id);
	List<CompteEP> getAllComptesep();
	
	

}
