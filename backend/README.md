# homework iii backend

this backend follows the exercise style with model kjar service modules

## what is implemented

- class diagram: `CLASS_DIAGRAM.md`
- data model in `model` module
- 4 forward chaining rules in `kjar/src/main/resources/rules/homework-rules.drl`
- 3 backward chaining queries in the same drl file
- rule activation and output printing in `service/src/main/java/com/sbnz/service/Application.java`

## rules

1. detect tachypnea by age
2. detect oxygen concern
3. detect breathing effort concern
4. combine respiratory and hydration concerns into urgent recommendation

## queries

- isSafeForHomeMonitoring
- getEscalationReasons
- getRequiredAction

## run

from project root

```bash
mvn -pl service -am compile
mvn -pl service -am exec:java -Dexec.mainClass=com.sbnz.service.Application
```

if your machine does not have maven in path run the same commands with your installed maven binary

## desktop frontend app

there is now a `frontend` module with a clickable desktop tester for multiple patients.

run it from backend root:

```bash
mvn -pl frontend -am compile
mvn -pl frontend -am exec:java -Dexec.mainClass=com.sbnz.frontend.DesktopApp
```

what you can do in the app:
- save multiple patients
- click patient id from the list to load data
- choose input model preset (standard, conservative, high-risk)
- run rules and see signals, recommendation, and query output
