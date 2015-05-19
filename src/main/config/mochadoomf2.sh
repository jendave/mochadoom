#!/bin/sh
cd "`dirname \"$0\"`"
java -Xmx1024m -jar mochadoom-1.6.1-SNAPSHOT.jar -iwad freedoom2.wad
