package com.InternSathi.InternSathiAssginement.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.InternSathi.InternSathiAssginement.Model.Destination;
import com.InternSathi.InternSathiAssginement.Service.DestinationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DestinationRestController {
	@Autowired
	private DestinationService destService;
	
	  @GetMapping("/destination/api/list")
	    public List<Destination> getAllDestination(){
	    	
	    	return destService.getAllDestination();
	    }
	    
	  @PostMapping("/destination/api/add")
	    public String addDestination(@RequestBody Destination destination) {
	    	
	    	destService.addDestination(destination);
	    	return "Addsuccess";
	    }
	  
	  @PutMapping("/destination/api/update")
	    public String updateDestination(@RequestBody Destination destination) {
	    	destService.updateDestination(destination);
	    	return "UpdateSuccess";
	    }
	  
	  @DeleteMapping("/destination/api/delete/{id}")
	    public String deleteDestination(@PathVariable int id) {
			destService.deleteDestination(id);
			return "Delete Success";
	    	
	    }
	  
	  @GetMapping("/destination/api/{id}")
		public Destination getOneDestination(@PathVariable int id) {
			return destService.getDestinationById(id);
		}
		
	  
	  

}
