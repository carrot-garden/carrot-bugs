#!/bin/bash

cd /tmp

git clone git://github.com/carrot-garden/carrot-bugger.git

cd carrot-bugger/carrot-bug-FELIX-2961-001

mvn clean package --define skipTests

cat ./target/classes/OSGI-INF/serviceComponents.xml

