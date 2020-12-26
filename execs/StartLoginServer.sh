#!/bin/bash
screen -Sdm LoginServer xterm -title 'LoginServer' -bg 'black' -fg 'white' -e 'java -Dfile.encoding=UTF8 -Xms128m -Xmx128m -cp lib/*:L2jCore.jar com.l2j.loginserver.L2LoginServer'
