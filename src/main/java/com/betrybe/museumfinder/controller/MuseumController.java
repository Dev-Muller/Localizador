package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Class representing a museumController.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private final MuseumServiceInterface museumService;

  public MuseumController(MuseumServiceInterface musuemService) {
    this.museumService = musuemService;
  }

  @PostMapping
  public ResponseEntity<Museum>  createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(museumService
      .createMuseum(ModelDtoConverter.dtoToModel(museumCreationDto)));
  }
}
