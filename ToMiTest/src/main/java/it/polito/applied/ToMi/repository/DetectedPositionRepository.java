package it.polito.applied.ToMi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.polito.applied.ToMi.pojo.DetectedPosition;

public interface DetectedPositionRepository extends MongoRepository<DetectedPosition, String>, CustomDetectedPositionRepository{

}
