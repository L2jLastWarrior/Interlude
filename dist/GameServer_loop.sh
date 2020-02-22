#!/bin/bash
err=1
until [ $err == 0 ];
do
        [ -f log/java0.log.0 ] && mv log/java0.log.0 "log/`date +%Y-%m-%d_%H-%M-%S`_java.log"
        [ -f log/stdout.log ] &&  mv log/stdout.log "log/`date +%Y-%m-%d_%H-%M-%S`_stdout.log"
        [ -f log/chat.log ] && mv log/chat.log "log/`date +%Y-%m-%d_%H:%M:%S`-chat.log"
        java -Dfile.encoding=UTF- -Xms1024m -Xmx1024m -cp lib/*:L2jCore.jar com.l2j.gameserver.GameServer > log/stdout.log 2>&1
        err=$?
        sleep 10
done
