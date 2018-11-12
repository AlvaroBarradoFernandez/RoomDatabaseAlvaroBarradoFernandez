@echo off
color 0f
adb kill-server
adb start-server
echo Conecte el Smarthphone por USB
set/p Pulse Intro para confirmar que ha sido conectado
adb devices
echo;
echo Elige el puerto:
set/p port=
echo;
adb tcpip :%port%
echo Desconete el Cable USB
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