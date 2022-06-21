# AtosTest
 
__Nom de la base de donnée:__ 
"atostest"
## Comment générer le fichier jar:
- ouvrir le projet dans un terminal;
- Saisir la phrase "mvn clean install"
- Aller dans le dossier target du projet et recuperer le fichier ".jar"

## Comment utiliser l'Api:

1. Pour enregistrer un utilisateur utilisez l'url : http://localhost:8080/atostest/api/saveUser dans Postman.

2. Pour afficher un utilisateur utilisez l'url : http://localhost:8080/atostest/api/getUserDetails/id dans Postman (id=1 par exemple).