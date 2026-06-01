# homework iii backend

this backend follows the exercise structure with `model`, `kjar`, and `service` modules.

## what is implemented

- class diagram: `class_diagram.png`
- data model in the `model` module
- forward chaining rules split by responsibility:
  - `10-triage-rules.drl`
  - `20-vitals-rules.drl`
  - `30-hydration-rules.drl`
  - `50-final-decision-rules.drl`
- complex event processing rules in `40-cep-rules.drl`
- backward chaining queries in `60-bc-queries.drl`
- event declaration for stream processing in `00-event-declarations.drl`
- template-driven rule generation from:
  - `rules/templates/age-thresholds.template`
  - `rules/templates/red-flags.template`
- rule activation and output printing in `service/src/main/java/com/sbnz/service/Application.java`

## rule groups

### forward chaining

- triage age-band and high-risk profile detection
- age-adjusted tachypnea and severe tachypnea
- oxygen monitor and hypoxemia detection
- breathing effort and hydration concern detection
- final recommendation generation

### cep

- rapid oxygen drop within `2h`
- breathing effort escalation within `6h`
- persistent tachypnea within `12h`

### backward chaining queries

- `isSafeForHomeMonitoring`
- `getEscalationReasons`
- `getRequiredAction`
- `getHomeMonitoringBlockers`
- category queries for respiratory, hydration, and risk-profile signals

### templates

templates generate additional rule instances for:

- age-specific respiratory thresholds
- red-flag findings and emergency escalation

template-generated signals are intentionally kept visible in the output so the template mechanism can be demonstrated during defense.

## run

from repository root:

```bash
cd backend
mvn -U clean install
mvn -pl service -am exec:java -Dexec.mainClass=com.sbnz.service.Application
```

if maven is not available in `PATH`, run the same commands with your installed maven binary.

## desktop frontend app

there is also a `frontend` module with an interactive desktop tester.

from repository root:

```bash
cd frontend
mvn clean compile exec:java -Dexec.mainClass=com.sbnz.frontend.DesktopApp
```

the app supports:

- saving multiple patients
- loading patient data from the list
- choosing input presets
- comparing fresh and learned session execution
- viewing activated rules, derived facts, final decisions, and query results
