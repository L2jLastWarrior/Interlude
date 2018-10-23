@echo off
@java -Djava.util.logging.config.file=console.cfg -cp ../gameserver/lib/*;lib/L2jCore.jar com.l2j.tools.dbinstaller.LauncherGS
@pause