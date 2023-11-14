package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class representing a generalControllerAdvice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {
    
  @ExceptionHandler(InvalidCoordinateException.class)
  @ResponseBody
  public ResponseEntity<String> handleInvalidCoordinateException(
      InvalidCoordinateException exception
  ) {
    return new ResponseEntity<>("Coordenada inválida!", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MuseumNotFoundException.class)
  @ResponseBody
  public ResponseEntity<String> handleMuseumNotFoundException(MuseumNotFoundException exception) {
    return new ResponseEntity<>("Museu não encontrado!", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResponseEntity<String> handleException(Exception exception) {
    return new ResponseEntity<>("Erro interno!", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
