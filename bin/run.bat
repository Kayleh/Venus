@echo off
echo.
echo [???] ???Jar????????Web?????
echo.

cd %~dp0
cd ../venus-admin/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% venus-admin.jar

cd bin
pause