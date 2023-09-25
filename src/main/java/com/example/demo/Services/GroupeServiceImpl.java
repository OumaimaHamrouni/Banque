package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GroupeRepository;
import com.example.demo.entity.Groupe;

@Service
public class GroupeServiceImpl implements GroupeService {
    
	@Autowired
	GroupeRepository grouperep ;
	
	@Override
	public Groupe saveGroupe(Groupe groupe) {
	
		return grouperep.save(groupe);
	}

	@Override
	public Groupe updateGroupe(Groupe groupe,Long id) {
		Groupe groupeupdate=grouperep.findById(id).get(); 
		groupeupdate.setNomGroupe(groupe.getNomGroupe());
		return grouperep.saveAndFlush(groupeupdate);
	}

	@Override
	public void deleteGroupe(Groupe groupe) {
		grouperep.delete(groupe);
		
	}

	@Override
	public void deleteGroupetById(Long id) {
		grouperep.deleteById(id);
		
	}

	@Override
	public Groupe getGroupe(Long id) {
		
		return grouperep.findById(id).get();
	}

	@Override
	public List<Groupe> getAllGroupes() {
	
		return grouperep.findAll();
	}

}
