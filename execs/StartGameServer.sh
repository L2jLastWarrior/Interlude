#!/bin/bash
screen -Sdm GameServer xterm -title 'GameServer' -bg 'black' -fg 'white' -e 'java -Dfile.encoding=UTF- -Xms1024m -Xmx1024m -cp lib/*:L2jCore.jar com.l2j.gameserver.GameServer'
