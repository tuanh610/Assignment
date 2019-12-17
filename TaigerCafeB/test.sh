#! /bin/bash
Date="15:30:00"
IFS=":" read -ra temp <<< "$Date"
hour=${temp[0]}
min=${temp[1]}
sec=${temp[2]}
res=$((hour*60*60+min*60+sec))
echo $res
array=("a c" b f "3 5")
IFS=$'\n' sorted=($(sort <<<"${array[*]}")); 
unset IFS
printf "[%s]\n" "${sorted[@]}"

