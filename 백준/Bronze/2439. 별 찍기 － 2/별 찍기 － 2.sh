read N

i=1
while [ $i -le $N ];
do

  j=1
  while [ $j -le $(( $N-$i )) ];
  do
    ((j++))
    echo -n ' '
  done
  k=1
  while [ $k -le $i ];
  do
    ((k++))
    echo -n '*'
  done
  ((i++))
  echo
done
