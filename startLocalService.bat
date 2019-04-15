rem start java -Xmx512m -Xms64m -Xmn174m -Xss174m bk_eureka.jar
@echo off
set /p a= please choose ( eureka, configServer ): 

if "%a%"=="bk_eureka" or "%a%"=="eureka"
(
	rem echo 1111111111111111111111111111
	rem pause
	start call java -jar -Xmx256m -Xms64m bk_eureka.jar
	pause
)
else
(
    if "%a%"=="bk_configServer" or "%a%"=="configServer"
	(
		rem echo 222222222222222222222222
		rem pause
		start call java -jar -Xmx256m -Xms64m bk_configServer.jar
		pause
	)
)
rem exit
rem start java -jar -Xmx256m -Xms64m bk_eureka.jar