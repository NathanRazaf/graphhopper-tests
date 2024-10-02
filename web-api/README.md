# Tests effectués et justification

## Helper
### [testHelperParseList()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L31-#L49):
- Cette fonction sert à tester la méthode `parseList` de la classe `Helper`. On veut s'assurer qu'elle fonctionne correctement pour un String qui représente une liste vide, et qu'elle enlève correctement les crochets du String donné en argument.

### [testHelperDateFormatting()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L58-#72):
- Ces deux fonctions sont utiles pour créer un format de date spécialisé, donc il est important de s'assurer de leur bon fonctionnement, d'où notre idée de les tester avec une date arbitraire.

## TurnCostsConfig

### [testTurnCostConfigCopy()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L80-#L87):
- Ces deux constructeurs sont essentiels pour créer rapidement une instance de TurnCostsConfig à partir d'un autre TurnCostsConfig ou une liste de véhicules respectivement, donc il serait bon de les tester.
- En particulier, on veut s'assurer que `TurnCostsConfig(List<String> vehicleTypes)` lance la bonne exception quand c'est nécessaire.

### [testTurnCostConfigInstantiation()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L95-#L103):
- Ces deux constructeurs sont triviaux donc faciles à tester, donc on l'a fait haha

### [testInvalidTurnCostConfigVehicleTypes()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L111-#L126):
- Ces deux exceptions n'ont étrangement pas été testées donc on en a profité pour le faire.

## GHPoint
### [testGHPointInstantiationFromGeoPoint()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L134-#L146):
- Il était important de s'assurer que cette fonction traite correctement un point donné en argument de cette manière, donc il fallait... le tester.

### [testGHPointInstantiationFromOtherMethods()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L154-#L164):
- On voulait s'assurer que la nuance dans l'ordre de la latitude et de la longitude du GHPoint créé par chacune de ces fonctions était exécutée correctement. On en a profité pour utiliser java-faker pour générer 2 nombres aléatoires pour `x` et `y`.

## PointList
### [test2DPointListMethods()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L172-#189):
- `PointList` est une classe importante pour décrire un itinéraire en 2D ou en 3D donc c'est important que les méthodes de bases fonctionnent bien.

### [test3DPointListMethods()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L198-#L221):
- Même justification que précédemment mais en 3D

### [testPointListCopy()](https://github.com/NathanRazaf/graphhopper-tests/blob/fdf65d81fcbe16a23f93907e6b9500f02deda6bf/web-api/src/test/java/com/graphhopper/GraphHopperWebApiNewUnitTests.java#L229-#248):
- `copy()` et `clone()` permettent de dupliquer une `PointList` existante donc on voudrait s'assurer que cette copie soit faite correctement.

