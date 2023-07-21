package com.InternSathi.InternSathiAssginement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InternSathi.InternSathiAssginement.Model.Booking;
import com.InternSathi.InternSathiAssginement.Repository.BookingRepository;
import com.InternSathi.InternSathiAssginement.Service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
    
	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	public void addBooking(Booking booking) {
	bookingRepo.save(booking);
		
	}

	@Override
	public List<Booking> getAllBooking() {
		
		return bookingRepo.findAll();
	}

}
