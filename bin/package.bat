@echo off
chcp 936 >nul

echo ================================================
echo [信息] 正在打包Web工程...
echo ================================================

rem 设置Maven相关路径
set "MAVEN_PATH=C:\Users\92493\AppData\Local\Programs\IntelliJ IDEA Ultimate 2\plugins\maven\lib\maven3\bin\mvn.cmd"
set "MAVEN_SETTINGS=D:\project\settings.xml"

rem 检查Maven路径
if not exist "%MAVEN_PATH%" (
    echo [错误] Maven路径不存在: %MAVEN_PATH%
    pause
    exit /b 1
)

rem 切换到项目根目录
cd /d %~dp0
cd ..

rem 执行Maven打包
echo [信息] 开始执行Maven打包...
call "%MAVEN_PATH%" -s "%MAVEN_SETTINGS%" clean package -Dmaven.test.skip=true
if errorlevel 1 (
    echo [错误] Maven打包失败
    pause
    exit /b 1
)

echo [信息] 打包完成
pause