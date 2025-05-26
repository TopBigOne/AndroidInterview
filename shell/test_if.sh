#!/bin/bash
a=2
b=7
if [ $a -ge $b ]; then
  echo "The variable 'a' is greater than the variable 'b'."
else
  echo "The variable 'b' is greater than the variable 'a'."
fi
c=3
d=7
if [ $c-eq $d ]; then
  echo "c==d"

fi
