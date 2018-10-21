@echo off
title L2jLastWarrior: Game Server Console
:start

REM -------------------------------------
REM Default parameters for a basic server.
java -Dfile.encoding=UTF8 -Xms1024m -Xmx1024m -cp ./lib/*;L2jCore.jar com.l2j.gameserver.GameServer
REM
REM If you have a big server and lots of memory, you could experiment for example with
REM java -server -Xmx1536m -Xms1024m -Xmn512m -XX:PermSize=256m -XX:SurvivorRatio=8 -Xnoclassgc -XX:+AggressiveOpts
REM -------------------------------------

if ERRORLEVEL 7 goto telldown
if ERRORLEVEL 6 goto tellrestart
if ERRORLEVEL 5 goto taskrestart
if ERRORLEVEL 4 goto taskdown
REM 3 - abort
if ERRORLEVEL 2 goto restart
if ERRORLEVEL 1 goto error
goto end
:tellrestart
echo.
echo Telnet server Restart ...
echo.
goto start
:taskrestart
echo.
echo Auto Task Restart ...
echo.
goto start
:restart
echo.
echo Admin Restart ...
echo.
goto start
:taskdown
echo .
echo Server terminated (Auto task)
echo .
:telldown
echo .
echo Server terminated (Telnet)
echo .
:error
echo.
echo Server terminated abnormally
echo.
:end
echo.
echo server terminated
echo.
:question
set choix=q
set /p choix=Restart(r) or Quit(q)
if /i %choix%==r goto start
if /i %choix%==q goto exit
:exit
exit
pause
