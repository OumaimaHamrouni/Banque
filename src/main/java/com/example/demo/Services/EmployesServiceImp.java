package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployesRepository;
import com.example.demo.dao.GroupeRepository;
import com.example.demo.entity.Employes;
import com.example.demo.entity.Groupe;

@Service
public class EmployesServiceImp implements EmployesService {

	
	@Autowired
	EmployesRepository  emprepo ;

	@Override
	public Employes saveEmployes(Employes emp) {
		return emprepo.save(emp);
	}

	@Override
	public List<Employes> getAllEmployes() {
	
		return emprepo.findAll();
	}

	@Override
	public void deleteEmployeé(Employes e) {
		
	 emprepo.delete(e);
	}

	@Override
	public void deleteemptById(Long id) {
		emprepo.deleteById(id);
		
	}

	@Override
	public Employes getEmp(Long id) {
		
		return  emprepo.findById(id).get();
	}
	


}

