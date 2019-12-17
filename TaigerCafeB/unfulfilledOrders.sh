#! /bin/bash

inputFile=${1}
order=${2}
orderDate=${3}
result=()
while read line 
do 	
	eval "array=($line)"
	arrLen=${#array[@]}

	#Make sure that line has 4 field
	if (( arrLen<4 || array[0] != orderDate ))
	then
		continue
	fi
	#Check order
	IFS='=' read -r name content <<< "${array[2]}"
	if [ "$name" != "order" ] || [ "$content" != "$order" ]
	then
		continue
	fi
	#Check result 
	IFS='=' read -r name content <<< "${array[3]}"
	if [ "$name" != "fulfilled" ] || [ "$content" != "FALSE" ]
	then
		continue
	fi
	#filter timing
	#IFS=":" read -ra temp <<< "${array[1]}"
	#hour=${temp[0]}
	#min=${temp[1]}
	#sec=${temp[2]}
	#res=$((hour*60*60+min*60+sec))
	#entry=$res" "$line	
	result+=( "$line" )
	#echo "${array[@]}"
done < "$inputFile"
IFS=$'\n' sorted=($(sort -k 2r <<<"${result[*]}"))
unset IFS
if [ "${#sorted}" -le 3 ]
then
	printf "%s\n" "${sorted[@]}"
else
	printf "%s\n" "${sorted[@]:0:3}"
fi
