package com.example.demo.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.Services.ClientService;
import com.example.demo.Services.EmployesService;
import com.example.demo.Services.GroupeService;
import com.example.demo.entity.Client;
import com.example.demo.entity.Employes;
import com.example.demo.entity.Groupe;
@Controller 
public class TymleafAdminController {
	@Autowired
	protected GroupeService groupeservice ;
	@Autowired
	protected EmployesService empservice ;
	
	
	@GetMapping("/admin/index")
    public String indexadmin(Model model) { 
        return  "indexadmin" ;	}
	


	//---------------------------------------------------------------------Controller Groupe Tymleaf---------------------------------------------------------------------
		@GetMapping("/Admin/Addgroupe")
	    public String addgroupe() {
	       
	
	        return  "addGroupe" ;	
		
		}
		
		@PostMapping("/savegroupe")
		    public String save_groupe(@ModelAttribute Groupe g) {
			 groupeservice.saveGroupe(g);
	           
		        return  "redirect:/Admin/Getallgroupe" ;	
			
		}
		
		
		@GetMapping("/Admin/UpdateGroupe/{id}")
		 public String updategroupe (Model model,@PathVariable Long id)
		 {
			 model.addAttribute("groupe",groupeservice.getGroupe(id)) ;
				
		        return  "updategroupepage" ;	
			
		 }
		 
		
		@GetMapping("/Admin/Getallgroupe")
	    public String showallgroupe(Model model) {
	        model.addAttribute("groupes",groupeservice.getAllGroupes()) ;
	
	        return  "listergroupe" ;	
		
		}
		
		 @GetMapping("/deletegroupe/{id}")
		    public String deletegroupe (@PathVariable Long id) {
			    groupeservice.deleteGroupetById(id);   
		        return  "redirect:/Admin/Getallgroupe" ;	
		 }
		//---------------------------------------------------------------------------Controller Employes Tymleaf --------------------------------------------------------
		 
		 @GetMapping("/Admin/AddEmployes")
		    public String addemployes(Model model) {
			 model.addAttribute("employee", new Employes());
			 model.addAttribute("empolyes", empservice.getAllEmployes()) ;
		     model.addAttribute("allgroupe",groupeservice.getAllGroupes());  
		        return  "addemployes" ;	
			
		  }
		
		@PostMapping("/saveEmployes")
		    public String save_employes(@ModelAttribute Employes e) {
                 
				empservice.saveEmployes(e);
	           
		        return  "redirect:/Admin/GetallEmploye" ;	
			
		  }
		
		@GetMapping("/Admin/GetallEmploye")
	    public String showallemp(Model model) {
	        model.addAttribute("emps",empservice.getAllEmployes()) ;
	
	        return  "Listeremployee" ;	
		
		}
		
		 @GetMapping("/deleteemployee/{id}")
		    public String deleteemp (@PathVariable Long id) {
			 empservice.deleteemptById(id); 
		        return  "redirect:/Admin/GetallEmploye" ;	
		 }
		
		 @GetMapping("/Admin/UpdateEmploye/{id}")
		 public String updateemp (Model model,@PathVariable Long id)
		 {
			 model.addAttribute("empolyes", empservice.getAllEmployes()) ;
		     model.addAttribute("allgroupe",groupeservice.getAllGroupes());
			 model.addAttribute("emp",empservice.getEmp(id)) ;
				
		        return  "updateemployee" ;	
			
		 }

}
