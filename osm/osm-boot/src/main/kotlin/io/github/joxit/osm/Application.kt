package io.github.joxit.osm

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
@EnableCaching    // gestion du cache
class Application

fun main(args: Array<String>) {
  SpringApplication.run(Application::class.java, *args)
}
