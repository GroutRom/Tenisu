# Tenisu
Tenisu Project

1. Installation et Exécution :

   a) Clonez le dépôt git : git clone https://github.com/GroutRom/Tenisu.git
   
   b) Accédez au projet tenisu
   
   c) Compilez le projet à l'aide de Maven : mvn clean install
   
   d) Lancez l'application : mvn spring-boot:run
   
   e) L'application devrait démarrer sur le port 9000
    
2. Test de l'Application :

   a) Pour tester l'application utiliser un navigateur web ou Postman

   b) Rendez-vous sur http://localhost:9000 pour vous connecter à l'application

   c) Vous pouvez essayer les difféents endpoints pour tester le projet :

      /players : Récupère tous les joueurs

      /player/{id} : Récupère un joueur par ID

      /playersByRank : Récupère tous les joueurs triés par classement

      /BestCountry : Récupère le pays avec le meilleur ratio de victoires

      /imcPlayers : Récupère l'IMC de chaque joueur

      /imcAverage : Récupère l'IMC moyen de tous les joueurs

      /median : Récupère la taille médiane des joueurs
