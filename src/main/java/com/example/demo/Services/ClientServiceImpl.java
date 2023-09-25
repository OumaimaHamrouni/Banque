package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entity.*;

@Service
public class ClientServiceImpl implements  ClientService {
	
	
	
	@Autowired
	ClientRepository clientRepository;

	public Client saveClient( Client c) {
		  
	 return clientRepository.save(c);
	}
	
	public Client updateClient(Client p) {
	  return  clientRepository.save(p);
	}
	
	public void deleteClient(Client p) {
	clientRepository.delete(p);
	}
	
	public void deleteClientById(Long id) {
	clientRepository.deleteById(id);
	}

	public Client getClient(Long id) {
	return clientRepository.findById(id).get();
	}
	
	
	public List<Client> getAllClients() {
	return clientRepository.findAll();
	}


}
