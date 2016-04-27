package it.polito.applied.ToMi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polito.applied.ToMi.pojo.DetectedPosition;
import it.polito.applied.ToMi.repository.DetectedPositionRepository;

@Service
public class AppServiceImpl implements AppService{
	
	@Autowired
	private DetectedPositionRepository posRepo;

	@Override
	public void saveDetectedPosition(List<DetectedPosition> position) {
		posRepo.insert(position);
	}

}
