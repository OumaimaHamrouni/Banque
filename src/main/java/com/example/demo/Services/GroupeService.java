package com.example.demo.Services;

import java.util.List;

import com.example.demo.entity.Groupe;



public interface GroupeService {
	Groupe saveGroupe (Groupe groupe);
	Groupe  updateGroupe(Groupe groupe,Long id);
	void deleteGroupe(Groupe groupe);
	void deleteGroupetById(Long id);
	Groupe getGroupe(Long id);
	List<Groupe> getAllGroupes();
}
