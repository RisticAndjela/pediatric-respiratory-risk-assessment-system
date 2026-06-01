# zadatak 3

## sta je implementirano

implementiran je backend projekat po uzoru na vezbe sa podelom na tri modula

- `model`
  - domenske klase koje predstavljaju cinjenice u sistemu
  - `ChildProfile`, `RespiratoryAssessmentEvent`, `HydrationIntakeEvent`, `ClinicalSignal`, `Recommendation`

- `kjar`
  - drools konfiguracija i pravila
  - `kmodule.xml` sa stateful session
  - `homework-rules.drl` sa pravilima i query-jima

- `service`
  - pokretanje scenarija
  - ubacivanje cinjenica
  - aktivacija pravila
  - prikaz rezultata i query odgovora

ovo direktno pokriva zahtev domaceg
- projekat po uzoru na vezbe
- model podataka
- 3-5 pravila
- aktivacija pravila i prikaz rezultata

## koja pravila su implementirana

implementirano je 5 fc pravila

1. `detect tachypnea by age`
- ulaz: uzrast deteta i respiratorna frekvenca
- izlaz: `ClinicalSignal(TACHYPNEA)`

2. `detect oxygen concern`
- ulaz: spo2 vrednost
- izlaz: `ClinicalSignal(OXYGEN_CONCERN)`

3. `detect breathing effort concern`
- ulaz: chest indrawing ili grunting
- izlaz: `ClinicalSignal(BREATHING_EFFORT)`

4. `detect emergency respiratory red flags`
- ulaz: apnea ili centralna cijanoza ili `spo2 < 90`
- izlaz: `Recommendation(EMERGENCY_RESPONSE)` + `ClinicalSignal(EMERGENCY_RED_FLAG)`

5. `make recommendation from combined signals`
- ulaz: kombinacija 3 respiratorna signala + los unos tecnosti
- izlaz: `Recommendation(URGENT_HOSPITAL_ASSESSMENT)`
- ovo pravilo ne radi ako je vec aktiviran `EMERGENCY_RESPONSE`

## koji query-ji su implementirani

implementirana su 3 bc upita

- `isSafeForHomeMonitoring(childId)`
  - proverava da li postoji urgent ili emergency preporuka

- `getEscalationReasons(childId, type, reason)`
  - vraca sve aktivne klinicke razloge eskalacije

- `getRequiredAction(childId, action, explanation)`
  - vraca finalnu preporuku i objasnjenje

## konkretan scenario i rezultat

koriscen je scenario
- dete: 10 meseci
- merenje 1: rr 54, spo2 95, chestIndrawing true, grunting false
- merenje 2: rr 58, spo2 94, chestIndrawing true, grunting true
- hydration: intakePercent 60, poorFeeding true

rezultat izvrsavanja
- `rules fired: 4` u ovom scenariju
- emergency pravilo se ne aktivira jer nema apnea/cijanoze i spo2 nije ispod 90
- izvedeni signali: `TACHYPNEA`, `OXYGEN_CONCERN`, `BREATHING_EFFORT`
- finalna preporuka: `URGENT_HOSPITAL_ASSESSMENT`
- `isSafeForHomeMonitoring` vraca `rows: 0`

## sta je expert-backed a sta je implementaciona odluka

expert-backed deo
- uzrasni pragovi za tahipneju: `2-11 meseci >= 50/min`, `12+ meseci >= 40/min`
- `spo2 <= 95` kao znak povisenog respiratornog rizika
- `spo2 < 90`, apnea i centralna cijanoza kao hitni red flag znaci

implementaciona odluka u ovoj fazi
- kako se signali grupisu u finalnu preporuku
- minimalan skup cinjenica za domaci demo
- tekstualna objasnjenja u `ClinicalSignal` i `Recommendation`

## zasto su ovo dobra resenja

- logika je podeljena na male korake umesto jednog velikog if-else bloka
- svaki korak proizvodi izvedenu cinjenicu, pa je odluka objasnjiva
- query-ji omogucavaju proveru i odbranu odluke
- struktura je ista kao na vezbama i uskladjena je sa predmetom
- pravila su dovoljno kompleksna za domaci iii, a i dalje jasna za demonstraciju

## sta je sledece

ova osnova je spremna za domaci iv
- moze se dodati jedan kompleksni mehanizam bez promene arhitekture
- najprirodniji nastavak je cep obrazac kroz vremenski prozor ili template tabela sa parametrima pragova
