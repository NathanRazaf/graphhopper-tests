# Méthodes testées et justification

## Helper
### [Helper.parseList(String listStr)](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/Helper.java#L421-#L434):
- On a décidé de tester extensivement cette fonction car elle est simple à comprendre, pourtant elle était entièrement non couverte avant qu'on ajoute nos tests.

### [Helper.createFormatter() / Helper.createFormatter(String str)](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/Helper.java#L342-#L353)
- Ces deux fonctions sont utiles pour créer un format de date spécialisé, donc il est important de s'assurer de leur bon fonctionnement, d'où notre idée de les tester.

## TurnCostsConfig
### [TurnCostsConfig(TurnCostsConfig copy) / TurnCostsConfig(List<String> vehicleTypes)](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/TurnCostsConfig.java#L47-#L64)
- Ces deux constructeurs sont essentiels pour créer rapidement une instance de TurnCostsConfig à partir d'un autre TurnCostsConfig ou une liste de véhicules respectivement, donc il serait bon de les tester.
- En particulier, on veut s'assurer que `TurnCostsConfig(List<String> vehicleTypes)` lance la bonne exception quand c'est nécessaire.

### [TurnCostsConfig.bike() / TurnCostsConfig.car()](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/TurnCostsConfig.java#L36-#L42)
- Ces deux constructeurs étaient faciles à tester donc on l'a fait.

## GHPoint
### [GHPoint.create(Point point)](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/shapes/GHPoint.java#L40-#L42)
- Il était important de s'assurer que cette fonction traite correctement un point donné en argument de cette manière, donc il fallait... le tester.

### [GHPoint.fromString / GHPoint.fromStringLonLat / GHPoint.fromJson](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/shapes/GHPoint.java#L44-#54)
- On voulait s'assurer que la nuance dans l'ordre de la latitude et de la longitude du GHPoint créé par chacune de ces fonctions était exécutée correctement.

## PointList
### [PointList.add()](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/PointList.java#L199-#L216)
- Cette fonction avec une surcharge était facile à comprendre et occupait plusieurs lignes non testées auparavant donc on a voulu combler ça.

### [PointList.reverse()](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/PointList.java#L294-#L315)
- Pareil ici.

### [PointList.clone(boolean reverse) / PointList.copy(int from, int end)](https://github.com/NathanRazaf/graphhopper-tests/blob/80058846bd7b956fdb5774921aca7324c70d5043/web-api/src/main/java/com/graphhopper/util/PointList.java#L424-#L469)
- Pareil ici.
