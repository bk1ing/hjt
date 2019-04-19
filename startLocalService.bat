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
rem nohup java -jar bk_eureka.jar --spring.profiles.active=bkEureka56  > bkEureka.log &

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

:start_zipkinServer
	start call java -jar zipkin-server-2.10.1-exec.jar --STORAGE_TYPE=mysql --MYSQL_DB=bkTi1 --MYSQL_USER=root --MYSQL_PASS=123 --MYSQL_HOST=172.16.16.90 --MYSQL_TCP_PORT=3306
rem nohup java -jar zipkin-server-2.10.4-exec.jar --STORAGE_TYPE=mysql --MYSQL_DB=bkTi1 --MYSQL_USER=root --MYSQL_PASS=123 --MYSQL_HOST=172.16.16.90 --MYSQL_TCP_PORT=3306   > zipkinServer.log &

:finish_exit
rem pause


rem exit
rem start java -jar -Xmx256m -Xms64m bk_eureka.jar

rem ============================================================================================
rem nohup java -jar zipkin.jar  > zipkin.log &

rem nohup java -jar bkEureka.jar --spring.profiles.active=bkEureka56  > bkEureka.log &
rem nohup java -jar bkEureka.jar --spring.profiles.active=bkEureka57  > bkEureka.log &
rem nohup java -jar bkEureka.jar --spring.profiles.active=bkEureka58  > bkEureka.log &

rem http://localhost:8005/commonConfig-default.yml
rem nohup java -jar bkConfigServer.jar  > bkConfigServer.log &

rem nohup java -jar bkAdmin.jar  > bkAdmin.log &
rem http://172.16.16.58:8008/

rem ============================================================================================
