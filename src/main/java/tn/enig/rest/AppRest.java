package tn.enig.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IDepartement;
import tn.enig.dao.IMateriel;
import tn.enig.model.Departement;

@RestController
@RequestMapping("/rest")
public class AppRest {

	
	
	@Autowired
	public IDepartement daoDep;
    @Autowired
	public IMateriel daoMat;
    
    
    @GetMapping("/allDep")
    public List<Departement> f(){
    	return daoDep.findAll();
    }
    @PostMapping("/add")
    public void f2(@RequestBody Departement dep) {
    	    daoDep.save(dep);
    }
    
    
    @DeleteMapping("/deleteDep/{id}")
    public void f3(@PathVariable int id) {
    	daoDep.delete(id); 
    }
}
