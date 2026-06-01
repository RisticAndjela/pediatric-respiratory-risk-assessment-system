@echo off
setlocal
cd /d "%~dp0\backend"

where mvn >nul 2>nul
if %errorlevel% neq 0 (
  echo Maven is not available in PATH.
  echo Install Maven and reopen terminal, then run this file again.
  pause
  exit /b 1
)

echo Building backend modules (model, kjar, service)...
mvn -U clean install
if %errorlevel% neq 0 (
  echo Backend build failed.
  pause
  exit /b 1
)

echo Backend build completed.
pause
