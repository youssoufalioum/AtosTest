# AtosTest
 
__Nom de la base de donn�e:__ 
"atostest"
## Comment g�n�rer le fichier jar:
- ouvrir le projet dans un terminal;
- Saisir la phrase "mvn clean install"
- Aller dans le dossier target du projet et recuperer le fichier ".jar"

## Comment utiliser l'Api:

1. Pour enregistrer un utilisateur utilisez l'url : http://localhost:8080/atostest/api/saveUser dans Postman.

__Avec pour body:__ 

{
    "name":"Youssoufou",
    "birthdate":"1992-05-19",
    "country":"France",
    "phone_number":"",
    "gender":""
}

2. Pour afficher un utilisateur utilisez l'url : http://localhost:8080/atostest/api/getUserDetails/id dans Postman (id=1 par exemple).