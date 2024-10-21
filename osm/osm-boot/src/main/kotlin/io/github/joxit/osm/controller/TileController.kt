package io.github.joxit.osm.controller

import io.github.joxit.osm.model.Tile
import io.github.joxit.osm.service.TileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import java.io.IOException
import java.nio.charset.StandardCharsets

/**
 * C'est le controlleur de l'application, il faut le déclarer comme tel et activer les CrossOrigin
 *
 * @since 18-10-2024
 */

@RestController
@CrossOrigin
@RequestMapping("/")

class TileController @Autowired constructor(private val tileService: TileService) {
  /**
   * Cette méthode est le point d'entrée de l'API, il prend les requêtes au format `/{z}/{x}/{y}.png`.
   * Attention, il doit renvoyer le header Content-Type image/png; voir les MediaType de Spring
   *
   * @param z zoom
   * @param x coordonée
   * @param y coordonée
   * @return l'image au format PNG
   */
  @GetMapping("/{z}/{x}/{y}.png", produces = [MediaType.IMAGE_PNG_VALUE])
  fun getTile(@PathVariable z: Int, @PathVariable x: Int, @PathVariable y: Int): ByteArray {
    val tile = Tile(z,x,y)
    return tileService.getTile(tile)
  }

  /**
   * Cette méthode est le point d'entrée des préfectures, il prend les requêtes sur l'entrée `/prefectures.geojson`.
   * Attention, il doit renvoyer le header Content-Type application/json
   *
   * @return String representant le GeoJSON des prefectures
   */
  @GetMapping("/prefectures.geojson", produces = [MediaType.APPLICATION_JSON_VALUE])
  @Throws(IOException::class)
  fun getPrefectures(): String {
    return tileService.getPrefectures()
  }
}
