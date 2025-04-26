Principe de fonctionnement plantVSDao


REST API = Allows a distant db (server) to communicate with the client and vice versa
--> REST = Representational State Transfer = Standardized architecture style
--> It's about communication

Restful webservice= a service that uses REST APIs to communicate

Benefits of REST API: 
1) Simple and Standardized approach to communication | We do not need to worry about the type of the data or of the format of the request
2) Scalable and stateless | As the service grows in complexity, we can easily make modifications
3) High performance in large part due to the fact they support caching 


REQUEST
--> Operation (POST GET PUT or DELETE) + Endpoint (like the ressource, for ex: CoursEpfBack/maps)
RESPONSE
--> In a JSON format

Equivalents in HTTP Methods:

C - Create --> POST
R - Read --> GET
U - Update --> PUT
D - Delete --> DELETE

Architecture en couche:

Controller → Service → DAO → Base de données
            ↑         ↑
         DTO        Model


Dans Controller:
		Tous les points d'entrée de l'API REST, les classes annotées avec @RestController: PlanteController, MapController, ZombieCOntroller
		C'est la que sont déclarées les routes HTTP: GET/plantes, POST/zombies, etc.

Dans Services:
		Les interfaces des services (les règles métiers) ➡ Définir ce qu'un service doit savoir faire 
			Ex: PlanteService contient les signatures comme createPlante(), getPlante(), etc.
		Les implémentations concrètes des services. 
			➡C'est là qu'on appelle les DAO (accès aux BDD) et qu'on gère les exceptions.
		Objectif: Séparer la logique métier (services) de l'accès aux données (DAO) Factoriser du code réutilisable
		Ex: PlanteService c'est un contrat qui dit: "Voici ce qu'un service plante doit pouvoir faire" --> on décrit les actions possibles mais on 		ne les programme pas.
		PlanteServiceImpl: C'est la qu'on implémente les vraies actions, elle dit comment on fait tout ca
		Resumé: Appelle les DAO, fait les traitements métiers, gère les exceptions

Dans Persistance/DAO:
		Gère l'accès à la BDD
		Les interfaces DAO (Data Access Object) avec des signatures pour communiquer avec la base
		Les implémenations concrètes des DAO. On y écrit des requêtes SQL (SELECT, INSERT, etc.) avec JDBCTemplate.

Dans Models:
		Les entités (objets métiers) qui correspondent aux données. Ex: Plante, Zombie. C'est un peu des classes "copie" de la BDD avec les 		attributs.

Dans DTO:
		Les DTO (Data Transfer Object)
		Objets "plus légers" utilisés entre le controller et le frontend ou une autre API.
		Pk les utiliser? On ne veut pas forcement envoyer tous les détails de Plante, juste l'essentiel, par ex sans les attributs techniques 		ou relations complexes

Fonctionnement global:
1) On fait une requête HTTP vers /plante
2) PlanteController reçoit la requête
3) Il appelle la méthode dans PlanteService
4) PlanteServiceImpl implémente cette méthode et appelle PlanteDAO
5) PlanteDAOImpl exécute une requête SQL sur la base
6) Le résultat est renvoyé en Plante -> Converti en PlanteDAO -> renvoyé au client

C'est un peu comme une entreprise: 
Élément		Rôle dans l’entreprise
Controller	L'accueil client 🧑‍💼 (reçoit les demandes HTTP)
Service		Les chefs de projet 🧠 (organisent les actions)
DAO		Les techniciens 📊 (font les accès aux données)
Model		Les fiches de chaque produit 📄 (données)







