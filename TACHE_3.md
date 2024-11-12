# Documentation tâche 3
* * *

### Build 1 : `java-version 22, jvm-flags -XX:+PrintCompilation`

`-XX:+PrintCompilation` : Affichage des méthodes compilées par le compilateur JIT

Ce flag permet d'afficher les méthodes compilées par le compilateur JIT de la JVM. Cela nous donne
plus de visibilité sur les méthodes qui demandent le plus de temps ou de ressources pour être compilées.
Si certaines méthodes réapparaissent souvent, cela peut indiquer qu'elles sont intensivement 
utilisées.

* * *
### Build 2 : `java-version 22, jvm-flags -Xms1g -Xmx1g`

`-Xms1g` : 1 Go de mémoire allouée au démarrage de la JVM

`-Xmx1g` : 1 Go de mémoire allouée au maximum à la JVM

Ces flags servent à contrôler la mémoire disponible pour le heap dans la JVM. Elle permet 
possiblement d'améliorer les performances de l'application en évitant que la JVM ait à allouer dynamiquement de la mémoire.
Donner la même valeur (1g) à ces deux flags permet également de réduire les pauses de garbage collection
en évitant que la JVM ait à redimensionner le heap.
* * *
### Build 3 : `java-version 22, jvm-flags -XX:+UseParallelGC`

`-XX:+UseParallelGC` : Utilisation du garbage collector parallèle

Ce flag permet d'utiliser le garbage collector parallèle de la JVM. 
Ce garbage collector est plus performant que le garbage collector par défaut car il est optimisé 
pour maximiser le débit en utilisant plusieurs threads pour collecter les objets morts en parallèle,
ce qui est plus efficace pour le build car c'est une tâche non interactive.

* * *

### Build 4 : `java-version 22, jvm-flags -XX:+TieredCompilation`

`-XX:+TieredCompilation` : Utilisation de la compilation à plusieurs niveaux

Ce flag permet de combiner les compilateurs JIT et l'interpréteur de la JVM pour améliorer la
performance globale.

* * *

### Build 5 : `java-version 22, jvm-flags -XX:+UseStringDeduplication`

`-XX:+UseStringDeduplication` : Utilisation de la déduplication de chaînes de caractères

Ce flag active la déduplication des chaînes de caractères en mémoire, ce qui signifie 
que la JVM cherche à identifier les chaînes identiques et à n'en conserver qu'une seule copie dans le tas.
Peut réduire la consommation de mémoire, surtout si le build manipule un grand nombre de chaînes de 
caractères identiques (comme des noms de méthodes, des chaînes de log ou des dépendances).

