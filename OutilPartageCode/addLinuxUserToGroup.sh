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
	echo "$0 nomUser nomGroupe"
	exit 2
fi

#Declaration des variables
nomUser=$1
nomGroupe=$2

#creation du groupe
addgroup $nomGroupe
exitIfError $?

#ajout de l'utilsateur dans le groupe
adduser $nomUser $nomGroupe
exitIfError $?


