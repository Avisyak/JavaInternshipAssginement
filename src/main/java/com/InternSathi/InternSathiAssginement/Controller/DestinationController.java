package com.InternSathi.InternSathiAssginement.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.InternSathi.InternSathiAssginement.Model.Destination;
import com.InternSathi.InternSathiAssginement.Service.DestinationService;

@Controller
public class DestinationController {
	
	@Autowired
	private DestinationService destService;
	
	@GetMapping("/adddestination")
	public String getAddDestination() {
		
		return "AddDestination";
	}
	@GetMapping("/destination")
	public String getDestination(Model model) {
	model.addAttribute("dlist",destService.getAllDestination());
		return "Destination";
	}
	
	@PostMapping("/adddestination")
	public String addDestination(@ModelAttribute Destination destination,@RequestParam MultipartFile image,Model model) {
		if(!image.isEmpty()) {
    		try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/photos/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		destination.setPhoto(image.getOriginalFilename());
		destService.addDestination(destination);
		model.addAttribute("message","New Destination Added");
		return "redirect:/adddestination";
		
	}
	
	@GetMapping("/getAlldestination")
	public String getAllDestination(Model model,HttpSession session) {
		model.addAttribute("dlist",destService.getAllDestination());
		return "ListDestination";
		
	}
	
	@GetMapping("/deletedestination")
	public String deleteBook(@RequestParam int id) {
		destService.deleteDestination(id);
		return "redirect:/getAlldestination";
		
	}
	@GetMapping("/editdestination")
	public String editBook(@RequestParam int id,Model model) {
		model.addAttribute("destinationmodel",destService.getDestinationById(id));
		return "EditDestination";
		
	}
    @PostMapping("/updatedestination")
	public String updateBook(@ModelAttribute Destination destination) {
		 destService.addDestination(destination);
		 return"redirect:/getAlldestination";
		
	}
	


}
