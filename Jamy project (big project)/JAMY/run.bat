@echo off
cd /d "%~dp0"

powershell -Command "Start-Process cmd -ArgumentList '/c cd /d ""%~dp0"" && java main' -Verb RunAs"