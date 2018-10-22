@echo off
title L2jLastWarrior GameServer Database Installer
java -Dfile.encoding=UTF8 -Xms128m -Xmx128m -cp ../gameserver/lib/*;L2jCore.jar com.l2j.tools.dbinstaller.LauncherLS
