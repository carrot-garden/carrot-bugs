#!/bin/bash

cd /tmp

git clone https://github.com/carrot-garden/carrot-bugger

cd carrot-bug-FELIX-2961-001

mvn clean package

cat ./target/classes/OSGI-INF/serviceComponents.xml

