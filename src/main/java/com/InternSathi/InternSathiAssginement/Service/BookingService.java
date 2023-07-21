package com.InternSathi.InternSathiAssginement.Service;

import java.util.List;
import com.InternSathi.InternSathiAssginement.Model.Booking;

public interface BookingService {
	void addBooking(Booking booking);
	List<Booking> getAllBooking();

}
