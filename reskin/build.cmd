@echo off
rem Rebuild the Perez Live reskin from the apktool-decoded project.
rem Usage: build.cmd <decoded-project-dir>
rem Requires: apktool.jar, JDK, Android SDK build-tools (zipalign + apksigner).

setlocal
set PROJ=%1
if "%PROJ%"=="" set PROJ=C:\Users\pc\vcfix\vc213_reskin
set JAVA=C:\Users\pc\vcfix\tools\jdk-17.0.20+8\bin\java.exe
set APKTOOL=C:\Users\pc\vcfix\tools\apktool.jar
set BT=C:\Users\pc\android-sdk\build-tools\31.0.0
set OUT=C:\Users\pc\vcfix\PerezLive_raw.apk
set ALIGNED=C:\Users\pc\vcfix\PerezLive_aligned.apk

"%JAVA%" -Xmx1536m -Xms256m -jar "%APKTOOL%" b "%PROJ%" -o "%OUT%" || goto :err
"%BT%\zipalign.exe" -f 4 "%OUT%" "%ALIGNED%" || goto :err
"%BT%\apksigner.bat" sign --ks %USERPROFILE%\.android\debug.keystore --ks-pass pass:android --key-pass pass:android --ks-key-alias androiddebugkey "%ALIGNED%" || goto :err
"%BT%\apksigner.bat" verify "%ALIGNED%" || goto :err
echo OK: %ALIGNED%
goto :eof
:err
echo BUILD FAILED
exit /b 1