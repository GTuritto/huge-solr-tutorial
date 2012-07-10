#!/bin/bash
MAVEN_OPTS="-Xmx2G" mvn clean compile install tomcat7:run

