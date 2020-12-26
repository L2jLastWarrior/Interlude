@echo off
title Account Manager
@java -Djava.util.logging.config.file=console.cfg -cp lib/*;lib/L2jCore.jar com.l2j.accountmanagers.AccountManager
@pause