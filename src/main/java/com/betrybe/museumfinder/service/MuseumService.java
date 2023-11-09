package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;

import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * Class representing a museumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  
  private final MuseumFakeDatabase museumDatabase;

  public MuseumService(MuseumFakeDatabase museumDatabase) {
    this.museumDatabase = museumDatabase;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException();
    }

    Museum savedMuseum = museumDatabase.saveMuseum(museum);

    return savedMuseum;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(coordinate);
    if (!isCoordinateValid) {
      throw new InvalidCoordinateException();
    }
    Optional<Museum> closest = museumDatabase.getClosestMuseum(coordinate, maxDistance);

    if (closest.isEmpty()) {
      throw new MuseumNotFoundException();
    }

    return closest.get();
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
