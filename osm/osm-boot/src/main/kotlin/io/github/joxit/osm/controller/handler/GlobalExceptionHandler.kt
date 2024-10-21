package io.github.joxit.osm.controller.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * Cette classe gère les exceptions qui sont levées dans l'application.
 * Elle intercepte les exceptions et renvoie une réponse appropriée.
 */
@ControllerAdvice
class GlobalExceptionHandler {

  /**
   * Gère les exceptions de type IllegalArgumentException.
   * Renvoie un code HTTP 400 (Bad Request) avec le message de l'exception.
   *
   * @param ex l'exception interceptée
   * @return une réponse HTTP avec un message d'erreur et un statut 400
   */
  @ExceptionHandler(IllegalArgumentException::class)
  fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<String> {
    return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)                     // Retourne une réponse 400 avec le message de l'exception
  }
}
