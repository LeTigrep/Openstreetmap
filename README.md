# OpenStreetMap

Ce projet est une application en Kotlin qui permet de gérer et de servir des tuiles cartographiques. Il utilise des données géospatiales et met à disposition des API pour accéder à ces informations.

## Prérequis

Assurez-vous que **Kotlin** soit installé sur votre machine.

Le projet utilise **Gradle** comme outil de build. 

JDK version 8 ou supérieure.

## Exécution

* Dans la structure du projet, accédez à ```src/main/kotlin/io/github/joxit/osm/Application.kt```

* Ouvrez le fichier ```Application.kt``` puis exécuter le serveur (clique droit puis run sur InteliJ)

Pour afficher la Map sur un navigateur :

```makefile
http://127.0.0.1:8080/0/0/0.png
``` 
Pour afficher le contenu du fichier geojson : 

```makefile
http://127.0.0.1:8080/prefectures.geojson
```
Pour afficher la carte avec les points précis :

```makefile
https://joxit.dev/IG-Master2/osm/osm-ui/?url=http://127.0.0.1:8080#2/40/-74.5
```

## Fichier de configuration

Le fichier ```application.properties``` dans le dossier ```resources``` contient les informations de configuration de l'application. 
