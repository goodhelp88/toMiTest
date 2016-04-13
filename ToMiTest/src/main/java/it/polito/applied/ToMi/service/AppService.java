package it.polito.applied.ToMi.service;

import java.util.List;

import it.polito.applied.ToMi.pojo.DetectedPosition;

public interface AppService {

	public void saveDetectedPosition(List<DetectedPosition> position);
}
