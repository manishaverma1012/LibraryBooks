#!/bin/bash

# Compile the program
javac -d out -sourcepath src/main/java src/main/java/com/library/*.java

# Run the program
java -cp out com.library.App

chmod +x build.sh

