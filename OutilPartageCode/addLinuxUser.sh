#!/bin/bash

#fonction de gestion des erreurs
function exitIfError {
	if [ $1 -ne 0 ];
	then
		errorCode=$((1000+$1))
		echo "exitIfError : $errorCode"
		exit $errorCode
	fi
}

#check root
if [ $EUID -ne 0 ];
then
	echo "Veuillez lancer ce script avec l'utilisateur root"
	exit 1
fi

#check args
if [ $# -ne 2 ];
then
	echo "Mauvais nombre d'argument. Format attendu :"
	echo "$0 nomUser motDePasse"
	exit 2
fi

#Declaration des variables
nomUser=$1
motDePasse=$2

# quiet : n'affiche que les erreurs et warnings (pas les infos)
# gecos : ne pas demander les informations complementaires (tel, email, etc.)
# disabled-login : pas de login tant que le mdp n'et pas setter
adduser --quiet --gecos "" --disabled-login $nomUser
exitIfError $?
#ajout du mdp
echo "$nomUser:$motDePasse" | chpasswd
exitIfError $?



