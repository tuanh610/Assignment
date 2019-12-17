#! /bin/bash

appleNo=0
pineAppleNo=0

while read line 
do 	
	length=${#line}
	temp=${line:0:length-1}
	if [ ${temp^^} == "APPLE" ]
	then
		(( appleNo++ ))
	elif [ ${temp^^} == "PINEAPPLE" ]
	then 
		(( pineAppleNo++ ))
	fi
done < ${1}

echo "Apple: " $appleNo ", PineApple: " $pineAppleNo 
case $2 in 
	"APPLE PIE")
		if (( appleNo>=3 ))
		then  
			echo "You shall have APPLE PIE!";
		else
			echo "You shall not have APPLE PIE!";
		fi;;
	"PINEAPPLE PIE")
		if (( pineAppleNo>=3 ))
		then  
			echo "You shall have PINEAPPLE PIE!";
		else
			echo "You shall not have PINEAPPLE PIE!";
		fi;;
	"FRUIT PARFAIT")
		if (( appleNo>=2 && pineAppleNo>=2 ))
		then  
			echo "You shall have FRUIT PARFAIT!";
		else
			echo "You shall not have FRUIT PARFAIT!";
		fi;;
	*)
		echo "We do not have that on the menu";;
esac
