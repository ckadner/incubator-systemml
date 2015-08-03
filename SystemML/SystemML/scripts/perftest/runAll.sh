#!/bin/bash 

if [ "$1" == "" -o "$2" == "" ]; then  echo "Usage: $0 <hdfsDataDir> <MR | SPARK | ECHO>   e.g. $0 perftest SPARK" ; exit 1 ; fi

#init time measurement
date >> times.txt

./runAllBinomial.sh $1 $2
./runAllMultinomial.sh $1 $2
./runAllRegression.sh $1 $2
./runAllStats.sh $1 $2
./runAllClustering.sh $1 $2
#ToDo run for all Beijing algs.



