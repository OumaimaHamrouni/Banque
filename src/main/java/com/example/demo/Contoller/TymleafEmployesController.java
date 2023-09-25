package com.example.demo.Contoller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import com.example.demo.Services.ClientService;
import com.example.demo.Services.CompteService;
import com.example.demo.Services.OperationServiceImp;
import com.example.demo.entity.Client;
import com.example.demo.entity.Compte;
import com.example.demo.entity.CompteCC;
import com.example.demo.entity.CompteEP;

@Controller 
public class TymleafEmployesController {
	@Autowired
	protected ClientService clientservice ;
	@Autowired
	protected CompteService  compteservice ;
	
	//---------------------------------------------------------------------------------employe index-----------------------------------
		@GetMapping("/Employe/index")
	    public String indexemp(Model model) { 
	        return  "indexemp" ;	}

	//-----------------------------------------------------------------------Client--------------------------------------------------------------------------------------------
		@GetMapping("/Employe/AddClient")
	    public String addclient() {
	       
	
	        return  "addclient" ;	
		
		}
		 @PostMapping("/saveclient")
		    public String save_client(@ModelAttribute Client c,String codeCompte,String dateCreation,Double solde ,Double decouvert,Double taux,String typecompte) throws ParseException {
			 
		        clientservice.saveClient(c);
	           
		      if(typecompte.equals("cc"))
		      {
		    	  CompteCC comptecc =new CompteCC() ;
		    	  comptecc.setCodeCompte(codeCompte);
		    	  comptecc.setSolde(solde);
		    	  comptecc.setDecouvert(decouvert);
		    	  comptecc.setClient(c);
		    	  
		    	  //date
		    	  DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	  Date date = formatter.parse(dateCreation);
		    	  comptecc.setDateCreation(date);
		    	  
		    	  compteservice.saveComptecc(comptecc);
		      }
		      
		      
		      if(typecompte.equals("ep"))
		      {
		    	  CompteEP compteep =new CompteEP() ;
		    	  compteep.setCodeCompte(codeCompte);
		    	  compteep.setSolde(solde);
		    	  compteep.setTaux(taux);
		    	  compteep.setClient(c);
		    	  
		    	  //date
		    	  DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	  Date date = formatter.parse(dateCreation);
		    	  compteep.setDateCreation(date);
		    	  
		    	  compteservice.saveCompteep(compteep);
		      }
		      
		        return  "redirect:/Employe/Getallclient" ;	
			
			}
		 
		 @GetMapping("/Employe/Getallclient")
		    public String showView2(Model model) {
		        model.addAttribute("clients",clientservice.getAllClients()) ;
		
		        return  "listerclients" ;	
			
			} 
		 
		 @GetMapping("/deleteclient/{id}")
		    public String deleteemp (@PathVariable Long id) {
			 clientservice.deleteClientById(id); 
		        return  "redirect:/Employe/Getallclient" ;	
		 }
		

		//-----------------------------------------Compte-----------------------------------------------------------------
		 @PostMapping("/savecompte/{id}")
		    public String save_compte(@PathVariable Long id,String codeCompte,String dateCreation,Double solde ,Double decouvert,Double taux,String typecompte) throws ParseException {
			   
		       Client client=new Client();
	           client.setCodeClient(id);
		      if(typecompte.equals("cc"))
		      {
		    	  CompteCC comptecc =new CompteCC() ;
		    	  comptecc.setCodeCompte(codeCompte);
		    	  comptecc.setSolde(solde);
		    	  comptecc.setDecouvert(decouvert);
		    	  comptecc.setClient(client);
		    	  
		    	  //date
		    	  DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	  Date date = formatter.parse(dateCreation);
		    	  comptecc.setDateCreation(date);
		    	  
		    	  compteservice.saveComptecc(comptecc);
		      }
		      
		      
		      if(typecompte.equals("ep"))
		      {
		    	  CompteEP compteep =new CompteEP() ;
		    	  compteep.setCodeCompte(codeCompte);
		    	  compteep.setSolde(solde);
		    	  compteep.setTaux(taux);
		    	  compteep.setClient(client);
		    	  
		    	  //date
		    	  DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	  Date date = formatter.parse(dateCreation);
		    	  compteep.setDateCreation(date);
		    	  
		    	  compteservice.saveCompteep(compteep);
		      }
		      
		        return  "redirect:/Employe/Getallclient" ;	
			
			}
		 @GetMapping("/Employe/Addcompte/{id}")
		 public String updategroupe (Model model,@PathVariable Long id)
		 {
			 model.addAttribute("idclient",id) ;
				
		        return  "addcompte" ;	
			
		 }
		 
		 //----------------------------------------------opreation-----------------------------------------------------
		 @Autowired
		    public OperationServiceImp operationserviceImp;

		    @RequestMapping(value = "/Employe/operations")
		    public String index(){
		        return "comptes";
		    }


		    @RequestMapping(value = "/Employe/consulterCompte" , method = RequestMethod.GET)
		    public String consulter(Model model , String codeCompte ,
		                            @RequestParam(name = "page",defaultValue = "0") int page ,
		                            @RequestParam(name = "size",defaultValue = "4") int size){
		        try{
		            Compte cp = operationserviceImp.consulterCompter(codeCompte).get();
		            Page listOperations = operationserviceImp.listOperation(codeCompte,page,size);
		            model.addAttribute("compte",cp);
		            model.addAttribute("listOperations",listOperations);
		            int[] pages = new int[listOperations.getTotalPages()];
		            model.addAttribute("pages",pages);
		            model.addAttribute("codeCompte",codeCompte);
		        }catch (Exception e){
		            model.addAttribute("exception","Compte introuvable");
		        }

		        return "comptes";
		    }
		    @RequestMapping(value="/save_op" ,method = RequestMethod.POST )
		    public String saveOperation(Model model ,  String typeOperation , String codeCompte , double montant , String codeCompte2){
		      try{
		          if(typeOperation.equals("VERS")){
		        	  operationserviceImp.verser(codeCompte,montant);
		          }        if(typeOperation.equals("RETR")){
		        	  System.out.println("REt");
		        	  operationserviceImp.reterait(codeCompte,montant);
		          }  if(typeOperation.equals("VIR")){
		        	  operationserviceImp.verement(codeCompte,codeCompte2,montant);
		          }
		      }catch (Exception e){
		          model.addAttribute("exception",e);
		          return "redirect:/Employe/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		      }

		        return "redirect:/Employe/consulterCompte?codeCompte="+codeCompte;
		    }
		
		    
}

