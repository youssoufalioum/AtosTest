# AtosTest
 
_Nom de la base de donn�e:_ 
"atostest"
## Comment g�n�rer le fichier jar:
- ouvrir le projet dans un terminal;
- Saisir la phrase "mvn clean install"
- Aller dans le dossier target du projet et recuperer le fichier ".jar"

## Comment utiliser l'Api:

1. Pour enregistrer un utilisateur utilisez l'url : http://localhost:8080/atostest/api/saveUser dans Postman.

2. Pour afficher un utilisateur utilisez l'url : http://localhost:8080/atostest/api/getUserDetails/id dans Postman (id=1 par exemple).