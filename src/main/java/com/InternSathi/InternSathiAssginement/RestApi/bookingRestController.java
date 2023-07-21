package com.InternSathi.InternSathiAssginement.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.InternSathi.InternSathiAssginement.Model.Booking;
import com.InternSathi.InternSathiAssginement.Service.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class bookingRestController {
	@Autowired
	private BookingService bookService;
	
	    @GetMapping("/booking/api/list")
	    public List<Booking> getAllBooking(){
	    	
	    	return bookService.getAllBooking();
	    }
	    
	    @PostMapping("/booking/api/add")
	    public String addBooking(@RequestBody Booking booking) {
	    	
	    	bookService.addBooking(booking);
	    	return "Addsuccess";
	    }
	 

}
