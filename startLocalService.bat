rem start java -Xmx512m -Xms64m -Xmn174m -Xss174m bk_eureka.jar
@echo off

:choose_work
set /p a= please choose ( exit, eureka, configServer, bkAdmin, ): 

rem if "%a%"=="quit" or "%a%"=="0" goto finish_exit
if "%a%"=="quit" goto finish_exit

if "%a%"=="eureka" goto start_eureka

if "%a%"=="configServer"  goto start_configServer

if "%a%"=="bkAdmin"  goto start_bkAdmin


:start_eureka
	start call java -jar -Xmx256m -Xms64m bk_eureka.jar
	goto choose_work
rem pause
rem exit

:start_configServer
	start call java -jar -Xmx256m -Xms64m bk_configServer.jar
	goto choose_work
rem pause
rem exit

:start_bkAdmin
	start call java -jar -Xmx256m -Xms64m bk_admin.jar
	goto choose_work
rem pause
rem exit

:finish_exit
rem pause


rem exit
rem start java -jar -Xmx256m -Xms64m bk_eureka.jar