# SBNZ Project - Quick Start

This repository has two top-level apps:

- `backend` - Drools rules and service logic
- `frontend` - desktop UI for interactive testing

## One-time prerequisites

- Java 17
- Maven 3.9+

## Run on any machine (double-click option)

From repository root you can use:

- `run-backend.bat`
  - builds and installs backend artifacts (`model`, `kjar`, `service`)
- `run-frontend.bat`
  - compiles and starts the desktop frontend app

Recommended order:

1. Double-click `run-backend.bat`
2. Double-click `run-frontend.bat`

## Terminal alternative (relative, machine-independent)

```bash
cd backend
mvn -U clean install

cd ../frontend
mvn clean compile exec:java -Dexec.mainClass=com.sbnz.frontend.DesktopApp
```

## Notes

- The app uses in-memory data for testing.
- Demo patients are loaded from `frontend/data/demo-children.csv`.
- If Maven or Java is missing from PATH, install them and reopen terminal.
