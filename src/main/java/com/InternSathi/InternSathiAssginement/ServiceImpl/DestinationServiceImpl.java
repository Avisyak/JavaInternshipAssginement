package com.InternSathi.InternSathiAssginement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InternSathi.InternSathiAssginement.Model.Destination;
import com.InternSathi.InternSathiAssginement.Repository.DestinationRepository;
import com.InternSathi.InternSathiAssginement.Service.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {
	@Autowired
	private DestinationRepository desRepo;

	@Override
	public void addDestination(Destination destination) {
		desRepo.save(destination);
		
	}

	@Override
	public void deleteDestination(int id) {

		desRepo.deleteById(id);
	}

	@Override
	public void updateDestination(Destination destination) {
		desRepo.save(destination);
		
	}

	@Override
	public Destination getDestinationById(int id) {
		
		return desRepo.findById(id).get();
	}

	@Override
	public List<Destination> getAllDestination() {
	
		return desRepo.findAll();
	}

}
