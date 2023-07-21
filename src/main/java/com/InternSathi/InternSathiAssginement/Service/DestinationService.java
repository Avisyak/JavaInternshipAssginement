package com.InternSathi.InternSathiAssginement.Service;

import java.util.List;

import com.InternSathi.InternSathiAssginement.Model.Destination;


public interface DestinationService {
	void addDestination(Destination destination);
	void deleteDestination(int id);
	void updateDestination(Destination destination);
    Destination getDestinationById(int id);
    List<Destination> getAllDestination();

}
