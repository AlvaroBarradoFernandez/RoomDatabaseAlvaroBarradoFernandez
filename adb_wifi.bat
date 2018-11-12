@echo off
color 0f
adb kill-server
adb start-server
adb devices
echo;
echo Elige el puerto:
set/p port=
echo;
adb tcpip :%port%
echo El puerto elegido es %port%
echo;
echo Escribe la IP de tu dispositivo:
set/p ip=
echo;
echo La ip elegida es %ip%
echo Conectando con %ip%:%port% ...
echo;
adb connect %ip%:%port%
echo Pulse Intro para Salir
pause>nul
exit