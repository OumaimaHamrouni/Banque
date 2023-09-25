package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompteCCRepository;
import com.example.demo.dao.CompteEPRepository;
import com.example.demo.dao.EmployesRepository;
import com.example.demo.entity.CompteCC;
import com.example.demo.entity.CompteEP;

@Service
public class CompteServiceImp implements CompteService {
	
	@Autowired
	CompteCCRepository  compteCCrepo ;
	
	@Autowired
	CompteEPRepository  compteEPrepo ;

	@Override
	public CompteCC saveComptecc(CompteCC comptecc) {
		
		return compteCCrepo.save(comptecc) ;
	}

	@Override
	public void deleteComptecc(CompteCC comptecc) {
		
		compteCCrepo.delete(comptecc);
	}

	@Override
	public void deleteCompteccById(String id) {
		compteCCrepo.deleteById(id);
		
	}

	@Override
	public CompteCC getComptecc(String id) {
		
		return compteCCrepo.findById(id).get();
	}

	@Override
	public List<CompteCC> getAllComptescc() {
		
		return compteCCrepo.findAll();
	}

	@Override
	public CompteEP saveCompteep(CompteEP compteep) {
	
		return compteEPrepo.save(compteep);
	}

	@Override
	public void deleteCompteep(CompteEP compteep) {
		compteEPrepo.delete(compteep);
		
	}

	@Override
	public void deleteCompteepById(String id) {
		compteEPrepo.deleteById(id);
		
	}

	@Override
	public CompteEP getCompteep(String id) {
		
		return compteEPrepo.findById(id).get();
	}

	@Override
	public List<CompteEP> getAllComptesep() {
		
		return compteEPrepo.findAll();
	}

}
