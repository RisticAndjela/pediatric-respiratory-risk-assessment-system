@echo off
setlocal
cd /d "%~dp0\frontend"

where mvn >nul 2>nul
if %errorlevel% neq 0 (
  echo Maven is not available in PATH.
  echo Install Maven and reopen terminal, then run this file again.
  pause
  exit /b 1
)

echo Launching desktop frontend app...
mvn clean compile exec:java "-Dexec.mainClass=com.sbnz.frontend.DesktopApp"
if %errorlevel% neq 0 (
  echo Frontend launch failed.
  echo Make sure backend was built first by running run-backend.bat.
  pause
  exit /b 1
)
