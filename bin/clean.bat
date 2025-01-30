@echo off
echo.
echo [信息] 清理工程target生成路径。
echo.

@REM maven 可执行文件地址
set mvnPath="C:\Users\92493\AppData\Local\Programs\IntelliJ IDEA Ultimate 2\plugins\maven\lib\maven3\bin\mvn"
@REM maven settings 文件地址
set settingsPath="D:\project\zy_yt\settings-zy.xml"

%~d0
cd %~dp0

cd ..
call %mvnPath% clean

pause