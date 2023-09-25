package com.example.demo.Services;


import java.util.List;
import com.example.demo.entity.*;


public interface ClientService {
	
	Client saveClient(Client client);
	Client updateClient(Client c);
	void deleteClient(Client c);
	void deleteClientById(Long id);
	Client getClient(Long id);
	List<Client> getAllClients();


}
