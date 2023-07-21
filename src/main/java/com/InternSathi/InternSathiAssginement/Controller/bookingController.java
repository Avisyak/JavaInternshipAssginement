package com.InternSathi.InternSathiAssginement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.InternSathi.InternSathiAssginement.Model.Booking;
import com.InternSathi.InternSathiAssginement.Service.BookingService;

@Controller
public class bookingController {
	@Autowired
    private BookingService bookservice;
	
	@PostMapping("/book")
	public String addBooking(@ModelAttribute Booking booking) {
		bookservice.addBooking(booking);
		return "HomePage";
	}
}
