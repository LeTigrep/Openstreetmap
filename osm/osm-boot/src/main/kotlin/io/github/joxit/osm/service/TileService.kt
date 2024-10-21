package io.github.joxit.osm.service

import io.github.joxit.osm.model.Tile
import io.github.joxit.osm.persistence.TileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.core.io.Resource
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Service pour retourner les tuiles.
 *
 * @since 18-10-2024
 */
@Service
class TileService @Autowired constructor(
  private val tileRepository: TileRepository
) {
  @Value("\${geojson.prefectures.path}")
  private lateinit var prefecturesGeoJson: Resource

  /**
   * Ici il faut prendre les coordonnées de la tuile et renvoyer la donnée PNG associée.
   * Vous pouvez y ajouter des fonctionnalités en plus pour améliorer les perfs.
   *
   * @param tile qu'il faut renvoyer
   * @return le byte array au format png
   */

  fun getTile(tile: Tile): ByteArray {
    return tileRepository.generateTile(tile)
  }

  /**
   * Cette méthode renvoie le contenu du fichier prefectures.geojson
   * présent dans le classpath du projet.
   *
   * @return le contenu du fichier prefectures.geojson au format String
   * @throws IOException en cas de problème lors de la lecture du fichier
   */
  @Throws(IOException::class)
  fun getPrefectures(): String {
    val resource = ClassPathResource("prefectures.geojson")

    // Utilise un InputStream pour lire le contenu du fichier
    resource.inputStream.use { inputStream ->
      return inputStream.bufferedReader().use { it.readText() }
    }
  }
}

