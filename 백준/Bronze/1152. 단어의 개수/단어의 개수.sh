read str

result=0

for word in $str; do
    ((result++))
done

echo $result
