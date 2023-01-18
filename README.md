# Projet-Programation-Application-Web
Utilise: Java, MySql, Servlet, Hibernate


Résumé : Notre projet consiste en un site d’un restaurant, il comporte 4 pages. La page d’accueil contient une petite introduction au restaurant et un carrousel affichant les photos du menu. La deuxième page est la page du menu, elle comporte les items du menu avec leurs descriptions et prix ainsi qu’un bouton pour ajouter l’item au panier avec la quantité désirée, la page du menu contient également un anglet Filtre qui vous permet d’appliquer une des trois catégories de filtres disponibles (Recherche par nom, recherche par tranche de prix et recherche par catégorie) en total 7 filtres sont disponibles. La troisième page est la page contact, elle comporte les informations sur le restaurant tel que l’adresse, le numéro de téléphone et les heures d’ouvertures. Finalement la quatrième page est la page du panier, elle comporte un tableau qui montre les items sélectionnés, leurs quantités, le total par item ainsi que la possibilité de modifier ou de supprimer un item. En bas du tableau, on peut trouver le total de la facture.

Instructions de déploiement du projet : Premièrement, il faut effectuer des modifications au fichier persistence.xml qui se trouve dans : src/main/resources/META-INF. Le nom de la base de données est : TpSessionRestaurant, on a utilisé MySql comme SGBD, reste à modifier le username et le password à la ligne 13 et 14.
Deuxièmement, il faut exécuter la classe de tests ItemMenuDaoImplTest.java (Ligne 14) qui se trouve dans : src/test/java/dao. Les tests vont permettre d’initialiser la base de donnée et de la remplir.

Versions utilisées :
-Tomcat : 9.0.68
-IntelliJ IDEA 2022.2.3 (Ultimate Edition)
