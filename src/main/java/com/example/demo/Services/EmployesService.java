package com.example.demo.Services;

import java.util.List;

import com.example.demo.entity.Employes;
import com.example.demo.entity.Groupe;

public interface EmployesService {
	Employes saveEmployes(Employes emp);
	List<Employes> getAllEmployes();
	void deleteEmployeé(Employes e);
	void deleteemptById(Long id);
	Employes getEmp(Long id);

}
