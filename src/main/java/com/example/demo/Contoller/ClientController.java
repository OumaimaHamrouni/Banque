package com.example.demo.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ClientService;
import com.example.demo.dao.CompteCCRepository;
import com.example.demo.dao.CompteEPRepository;
import com.example.demo.entity.Client;
import com.example.demo.entity.Compte;
import com.example.demo.entity.CompteCC;
import com.example.demo.entity.CompteEP;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	protected ClientService clientservice ;
	
	
	@PostMapping("/addclient")
	public Client Add_Client( @RequestBody Client c) {
		return clientservice.saveClient(c);
	}
	
	@PutMapping("/updatclient") 
	public Client updateE(@RequestBody Client c)
	{
		return clientservice.updateClient(c);
	}
	
	@DeleteMapping("/deleteclient") 
	public void deleteclient(@RequestBody Client c)
	{
		 clientservice.deleteClient(c);
	}
	
	@GetMapping("/getallclient")
	public List<Client> afficherToutE()
	{
		return clientservice.getAllClients() ;
	}
	//test------------------------------------------------------
	@Autowired
	protected CompteEPRepository repoep;
	@Autowired
	protected CompteCCRepository repocc;
	@GetMapping("/ListercompteEP")
	public List<CompteEP> l_e( ) {
		return repoep.findAll();
	}
	@GetMapping("/ListercompteCC")
	public List<CompteCC> l_C( ) {
		return repocc.findAll();
	}
	
	@PostMapping("/addcompteep")
	public CompteEP Add_EP(@RequestBody CompteEP c ) {
		return repoep.save(c);
	}
	
	@PostMapping("/addcomptecc")
	public CompteCC Add_CC(@RequestBody CompteCC c ) {
		return repocc.save(c);
	}
	

	
	
}
