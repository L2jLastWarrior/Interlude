@echo off
title Register GameServer
@java -Djava.util.logging.config.file=console.cfg -cp lib/*;lib/L2jCore.jar com.l2j.gsregistering.GameServerRegister
@pause
