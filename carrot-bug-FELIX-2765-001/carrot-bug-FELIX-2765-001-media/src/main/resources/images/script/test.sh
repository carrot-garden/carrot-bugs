#!/bin/bash

echo "###### test"

ARG1="$1"
ARG2="$2"

echo "###### ARG1=$ARG1 ARG2=$ARG2"

THIS_PATH=$(dirname $(readlink -f $0))

echo "###### THIS_PATH=$THIS_PATH"

  