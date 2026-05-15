# SBNZ — Predlog projekta

## Sistem baziran na znanju za ranu procenu rizika od pogoršanja respiratornih infekcija kod dece uzrasta od 2 meseca do 5 godina i preporuku daljeg postupanja

---

## 1. Članovi tima
- Anđela Ristić SV67-2022

---

## 2. Motivacija

Akutne respiratorne infekcije su među najčešćim razlozima zbog kojih se deca dovode kod pedijatra ili u hitnu službu. Problem u praksi nije samo prepoznavanje da dete ima kašalj, povišenu temperaturu ili otežano disanje, već **pravovremeno uočavanje da se stanje pogoršava** i razlikovanje situacija koje mogu da se prate kod kuće od onih koje zahtevaju pregled istog dana, upućivanje u bolnicu ili hitnu reakciju.

Kod male dece procena se često zasniva na kombinaciji više nalaza: uzrasta, frekvence disanja, saturacije kiseonika, uvlačenja grudnog koša, prisustva nazalnog širenja, grunting-a, kvaliteta uzimanja tečnosti, broja mokrih pelena, opšteg izgleda deteta i toka simptoma kroz vreme. Dodatni problem je što se isti nalaz ne tumači jednako u svim uzrastima: prag za tahipneju zavisi od starosti, a isto važi i za procenu opšteg rizika.

Zvanične smernice, kao što su WHO IMCI pristup za dete uzrasta od 2 meseca do 5 godina, WHO Pocket Book of Hospital Care for Children, NICE smernice za bronhiolitis i NICE smernice za febrilnu bolest kod dece mlađe od 5 godina, daju jasna pravila za:

- prepoznavanje znakova ozbiljne bolesti,
- razlikovanje nižeg i višeg rizika,
- prepoznavanje situacija u kojima je potrebna hitna procena,
- procenu da li je bezbedno kućno praćenje.

Međutim, te smernice su u praksi raspoređene kroz više dokumenata i najčešće se koriste kao statički vodiči ili ček-liste. Lekar ili roditelj i dalje moraju sami da povežu:

- više uzastopnih merenja kroz vreme,
- promene u radu disanja,
- pad unosa tečnosti,
- uzrasno zavisne pragove,
- prisustvo faktora rizika za teži tok bolesti.

Cilj projekta je razvoj sistema baziranog na znanju koji ova pravila prevodi u **izvršiva pravila**, prati simptome i merenja kroz vreme, procenjuje rizik od pogoršanja i daje preporuku daljeg postupanja.

Važno ograničenje domena je da sistem **nije namenjen za konačnu etiološku dijagnozu** niti za samostalno propisivanje terapije. Fokus projekta je na **ranoj proceni pogoršanja, klasifikaciji rizika, trijaži i preporuci nivoa reakcije** kod dece sa akutnim respiratornim simptomima.

Ovaj projekat nije zamišljen da odgovori na pitanje:

- „Koju tačno bolest dete ima?“

Veći fokus je na pitanjima:

- „Da li se stanje pogoršava?“
- „Da li je bezbedno ostati na kućnom praćenju?“
- „Da li je potreban pregled istog dana?“
- „Da li postoje razlozi za urgentnu ili hitnu eskalaciju?“

---

## 3. Pregled problema i pregled literature

### 3.1 Domen problema

Predloženi sistem obuhvata decu uzrasta **od 2 meseca do 5 godina** sa akutnim respiratornim simptomima kao što su:

- kašalj,
- ubrzano ili otežano disanje,
- povišena temperatura,
- nazalno širenje,
- uvlačenje grudnog koša,
- šištanje ili pucketanja pri disanju ako ih kliničar registruje,
- loš unos tečnosti,
- smanjen broj mokrih pelena,
- pospanost, slab odgovor ili iscrpljenost.

Opseg je sužen na uzrast od 2 meseca do 5 godina zato što su za tu grupu jasno definisani WHO IMCI i WHO Pocket Book pragovi za procenu kašlja i otežanog disanja, uključujući klasifikaciju na:

- tešku pneumoniju ili vrlo tešku bolest,
- pneumoniju,
- kašalj ili prehladu bez znakova pneumonije.

WHO navodi da se dete sa kašljem ili otežanim disanjem procenjuje merenjem frekvence disanja, traženjem uvlačenja grudnog koša i stridora u miru; prisustvo uvlačenja grudnog koša, stridora u miru ili opšteg znaka opasnosti ukazuje na tešku pneumoniju ili vrlo tešku bolest i zahteva upućivanje, dok brzo disanje bez tih znakova ukazuje na pneumoniju. WHO Pocket Book dodatno navodi pragove brzog disanja:

- `2–11 meseci`: `>= 50/min`
- `1–5 godina`: `>= 40/min`

Isti dokument navodi da na tešku pneumoniju ukazuju, između ostalog:

- centralna cijanoza ili saturacija `< 90%`,
- teški respiratorni distres,
- opšti znak opasnosti kao što su nemogućnost pijenja/dojenja, letargija ili poremećaj svesti, konvulzije.

Pored WHO pristupa, NICE smernice za febrilnu bolest kod dece mlađe od 5 godina preporučuju procenu rizika ozbiljne bolesti kroz traffic-light sistem i navode da treba razmotriti pneumoniju kod deteta sa temperaturom i znacima kao što su:

- tahipneja,
- krkljanje ili pukoti na plućima,
- nazalno širenje,
- uvlačenje grudnog koša,
- cijanoza,
- saturacija kiseonika `<= 95%` na sobnom vazduhu.

NICE takođe za procenu rizika navodi respiratorne znakove različite težine, uključujući:

- tahipneju,
- nazalno širenje,
- grunting,
- umereno ili teško uvlačenje grudnog koša,
- saturaciju `<= 95%`,
- smanjenu aktivnost i znake poremećaja hidracije.

Za bronhiolitis, NICE navodi da je posebno važno meriti saturaciju kiseonika kod svakog deteta sa sumnjom na bronhiolitis i prepoznati znakove zbog kojih je potrebna hitna ili brza procena, kao što su:

- apneja,
- centralna cijanoza,
- ozbiljan utisak bolesti,
- teški respiratorni distres, na primer grunting, izraženo uvlačenje grudnog koša ili respiratorna frekvenca `> 70/min`,
- neadekvatan unos tečnosti,
- klinička dehidratacija,
- trajno snižena saturacija.

Na osnovu toga, projekat ne pokušava da pokrije kompletnu pedijatrijsku dijagnostiku, već sledeći uži problem:

**Kako, na osnovu simptoma, vitalnih parametara, hidracije, faktora rizika i promena kroz vreme, proceniti da li dete sa akutnom respiratornom infekcijom ostaje niskog rizika ili prelazi u stanje koje zahteva bržu ili hitnu medicinsku reakciju?**

Zbog toga je centralni cilj projekta **trijaža i rana eskalacija**, a ne diferencijalna dijagnostika svih mogućih pedijatrijskih bolesti. U praksi, sistem klasifikuje:

- nizak rizik uz kućno praćenje,
- potrebu za pregledom istog dana,
- potrebu za urgentnom bolničkom procenom,
- potrebu za hitnom reakcijom.

### 3.2 Postojeća rešenja

U praksi se ovaj problem najčešće rešava kroz nekoliko vrsta alata:

1. **Statičke kliničke smernice i ček-liste**
   - WHO IMCI kartice,
   - WHO Pocket Book preporuke,
   - NICE traffic-light tabele,
   - NICE smernice za bronhiolitis.

2. **Pojedinačna merenja bez dubljeg rezonovanja**
   - pulsni oksimetar,
   - ručno brojanje respiracija,
   - jednokratna procena rada disanja,
   - pojedinačna provera unosa tečnosti ili broja mokrih pelena.

3. **Opšti informacioni sistemi i elektronski kartoni**
   - sistemi koji beleže merenja i simptome,
   - sistemi koji prikazuju podatke, ali ne nužno i lanac zaključivanja nad njima.

Nedostaci ovih pristupa su:

- pravila su raspodeljena kroz više dokumenata i nisu objedinjena u jedan izvršiv model odlučivanja,
- procena je često zasnovana na jednom preseku stanja, a ne na promeni kroz vreme,
- uzrasno zavisni pragovi zahtevaju ručnu interpretaciju,
- nije trivijalno objediniti respiratorne nalaze, hidraciju i opšti utisak bolesti u jedinstvenu preporuku,
- roditeljski ili ambulantni unos kroz više vremenskih tačaka često ne daje automatsko upozorenje na trend pogoršanja,
- sistemi uglavnom ne daju dovoljno eksplicitno objašnjenje zašto je neko dete klasifikovano kao niskog, srednjeg ili visokog rizika.

### 3.3 Prednost predloženog rešenja

Prednost predloženog rešenja je u tome što nad kliničkim i roditeljskim unosima uvodi formalizovano zaključivanje:

- **objedinjuje više smernica u jedan model** procene respiratornog rizika,
- **koristi uzrasno zavisne pragove** za disanje i druge parametre,
- **prepoznaje obrasce pogoršanja kroz vreme** umesto da gleda samo jedan trenutak,
- **uzima u obzir faktore rizika za teži tok bolesti**, na primer veoma mali uzrast ili komorbiditete,
- **daje nivo preporuke postupanja**, a ne samo listu simptoma,
- **gradi lanac dokaza** za odluku, što je naročito važno u medicinskom domenu,
- **omogućava primenu FC, BC, CEP i templates**, što je važno i sa strane predmeta.

Sistem ne zamenjuje pedijatra. Njegova uloga je:

- standardizacija procene,
- rano uočavanje pogoršanja,
- transparentna podrška odlučivanju,
- pomoć u trijaži i praćenju.

### 3.4 Reference

1. World Health Organization. *Pocket Book of Hospital Care for Children: Guidelines for the Management of Common Childhood Illnesses. 2nd edition.* Geneva: WHO; 2013.
2. World Health Organization. *Integrated Management of Childhood Illness (IMCI) Adaptation Guide* — section on cough or difficult breathing. WHO.
3. NICE. *Fever in under 5s: assessment and initial management (NG143).* National Institute for Health and Care Excellence.
4. NICE. *Bronchiolitis in children: diagnosis and management (NG9).* National Institute for Health and Care Excellence.
5. NICE. *Suspected sepsis in under 16s: recognition, diagnosis and early management (NG254).* National Institute for Health and Care Excellence.

---

## 4. Metodologija rada

### 4.1 Ulazi u sistem

**Profil deteta (statične činjenice)**:

- identifikator deteta,
- uzrast u mesecima ili godinama,
- telesna masa,
- gestacijska starost pri rođenju ako je relevantna,
- komorbiditeti i rizična stanja:
  - hronična plućna bolest,
  - hemodinamski značajna urođena srčana mana,
  - neuromišićna bolest,
  - imunodeficijencija,
  - prevremenost,
  - prethodne hospitalizacije zbog respiratornih problema,
- podatak da li dete pripada grupi vrlo malog uzrasta sa većim rizikom.

**Početni kontekst epizode bolesti**:

- datum početka simptoma,
- da li dominira kašalj, otežano disanje, temperatura ili kombinacija,
- da li je dete već viđeno od strane lekara,
- da li je prethodno postavljena radna sumnja na bronhiolitis, pneumoniju, virusnu infekciju gornjih disajnih puteva ili nespecifikovanu respiratornu infekciju.

**Događaji i merenja kroz vreme**:

- `RespiratoryAssessmentEvent`
  - vreme merenja,
  - respiratorna frekvenca,
  - saturacija kiseonika na sobnom vazduhu ako je dostupna,
  - srčana frekvenca ako je dostupna,
  - temperatura,
  - prisustvo nazalnog širenja,
  - prisustvo uvlačenja grudnog koša,
  - prisustvo grunting-a,
  - prisustvo cijanoze,
  - prisustvo apneje,
  - nivo aktivnosti deteta.

- `HydrationIntakeEvent`
  - procenjeni unos tečnosti u odnosu na uobičajeni,
  - da li dete pije ili doji loše,
  - broj mokrih pelena ili vreme od poslednjeg mokrenja,
  - prisustvo suvih sluznica,
  - smanjen urin.

- `GeneralDangerSignEvent`
  - nemogućnost pijenja ili dojenja,
  - letargija ili poremećaj svesti,
  - konvulzije,
  - dete izgleda ozbiljno bolesno,
  - progresivna iscrpljenost.

- `ClinicalFindingEvent` ako postoji pregled lekara:
  - pukoti/krkljanje,
  - wheeze,
  - stridor u miru,
  - procena da li rad disanja raste,
  - procena da li postoji klinička dehidratacija.

**Prelazni i sistemski događaji**:

- `ReferralDecisionEvent` — da je dete upućeno na pregled ili u bolnicu,
- `ObservationStartEvent` — da je pokrenuto kućno ili ambulantno praćenje,
- `ReassessmentEvent` — kontrolna tačka nakon zadatog vremena.

### 4.2 Izlazi sistema

**Za korisnika sistema / kliničara**:

- klasifikacija nivoa rizika:
  - `LOW_RISK_HOME_MONITORING`
  - `NEEDS_SAME_DAY_CLINICAL_REVIEW`
  - `URGENT_HOSPITAL_ASSESSMENT`
  - `EMERGENCY_RESPONSE`
- lista razloga koji su doveli do klasifikacije,
- objašnjenje koji pragovi su prekoračeni,
- objašnjenje koji se obrazac pogoršanja razvio kroz vreme,
- preporuka kada treba sledeća procena ako nije hitno upućivanje.

**Za roditelja ili staratelja**:

- jasna preporuka postupanja:
  - nastaviti kućno praćenje,
  - javiti se pedijatru istog dana,
  - odmah otići u hitnu službu / bolnicu,
- lista red flag znakova na koje treba obratiti pažnju,
- upozorenje ako dete prelazi iz nižeg u viši nivo rizika.

**Sistemski izlazi**:

- audit log svih odluka i aktiviranih pravila,
- istorija svih procena i promene nivoa rizika,
- izveštaji o tome:
  - koja deca su trenutno u aktivnom praćenju,
  - koja imaju rastući trend rizika,
  - kod kojih je okinut hitni alarm.

**Granice sistema i odgovornost**:

- sistem je **alat za podršku odlučivanju**, a ne zamena za pedijatra ili hitnu službu;
- sistem **ne postavlja konačnu dijagnozu** tipa „ovo je sigurno pneumonija“ ili „ovo je sigurno bronhiolitis“;
- sistem **ne propisuje terapiju** niti doze lekova;
- sistemova uloga je da, na osnovu smernica i unetih podataka, proceni rizik pogoršanja i preporuči nivo daljeg postupanja;
- u svim slučajevima sa kritičnim ili kontradiktornim nalazima klinička procena lekara ima prioritet nad automatskom preporukom sistema.

### 4.3 Baza znanja

#### 4.3.1 Glavni entiteti domena

**Šta sistem treba da zna**

Predloženi model domena sastoji se od sledećih glavnih klasa i tipova činjenica:

- `ChildProfile`
  - osnovni profil deteta, uzrast, komorbiditeti, rizične grupe;
- `IllnessEpisode`
  - jedna konkretna epizoda respiratorne bolesti koja se prati kroz vreme;
- `RespiratoryAssessmentEvent`
  - respiratorna frekvenca, saturacija, temperatura, rad disanja i opšte stanje u jednoj vremenskoj tački;
- `HydrationIntakeEvent`
  - unos tečnosti, mokrenje i znaci moguće dehidratacije;
- `GeneralDangerSignEvent`
  - prisustvo opštih znakova opasnosti;
- `ClinicalFindingEvent`
  - nalazi lekara ili zdravstvenog radnika, kao što su wheeze, crackles, stridor ili klinička dehidratacija;
- `RiskFactor`
  - formalizovana činjenica o prisustvu faktora rizika za teži tok bolesti;
- `DerivedClinicalState`
  - izvedene činjenice kao što su `TachypneaDetected`, `WorkOfBreathingIncreased`, `HydrationConcern`, `HypoxemiaConcern`;
- `RiskAssessment`
  - trenutna klasifikacija nivoa rizika;
- `Recommendation`
  - preporuka daljeg postupanja;
- `ExplanationItem`
  - element lanca objašnjenja odluke;
- `AuditEntry`
  - zapis o pravilima i događajima koji su doveli do procene.

1. **Uzrasno zavisne respiratorne pragove**
   - WHO pragovi za brzo disanje:
     - `2–11 meseci`: `>= 50/min`
     - `1–5 godina`: `>= 40/min`
   - NICE pragovi i respiratorni znaci koji povećavaju verovatnoću ozbiljne bolesti kod febrilnog deteta mlađeg od 5 godina.

2. **Znake ozbiljne respiratorne bolesti ili pogoršanja**
   - centralna cijanoza,
   - apneja,
   - grunting,
   - umereno ili teško uvlačenje grudnog koša,
   - izraženo nazalno širenje,
   - saturacija ispod definisanih pragova,
   - iscrpljenost, slab odgovor ili pad respiratornog napora,
   - nemogućnost uzimanja tečnosti,
   - znaci dehidratacije.

3. **WHO opšte znake opasnosti**
   - nemogućnost da pije ili doji,
   - letargija ili poremećaj svesti,
   - konvulzije.

4. **Rizične faktore za teži tok bolesti**
   - uzrast ispod 3 meseca,
   - prevremenost,
   - hronična plućna bolest,
   - značajna srčana mana,
   - neuromišićna bolest,
   - imunodeficijencija.

5. **Pravila za kontekstualno tumačenje saturacije**
   - WHO Pocket Book koristi `< 90%` kao važan prag za hipoksiju i tešku pneumoniju,
   - NICE za bronhiolitis koristi pragove za upućivanje, prijem i kiseoničku terapiju zavisno od uzrasta i kliničkog konteksta,
   - NICE za febrilnu bolest navodi `<= 95%` kao znak koji može povećati sumnju na pneumoniju ili ozbiljniju bolest.

6. **Pravila za procenu toka bolesti kroz vreme**
   - da li se respiratorna frekvenca održava iznad praga u više uzastopnih merenja,
   - da li saturacija opada kroz vreme,
   - da li se povećava rad disanja,
   - da li unos tečnosti opada,
   - da li dete postaje manje reaktivno ili iscrpljenije.

#### 4.3.2 Eksplicitno mapiranje na tehnike sa predmeta

Tehnike sa predmeta koristićemo ovako:

- **Forward chaining (FC)**  
  Koristi se za standardno izvođenje novih činjenica iz unetih simptoma i merenja. Primeri:
  - iz uzrasta i respiratorne frekvence izvodi se `TachypneaDetected`;
  - iz saturacije i kliničkog konteksta izvodi se `OxygenationConcern`;
  - iz više izvedenih činjenica izvodi se `ClinicalReviewNeeded` ili `UrgentReferralNeeded`.

- **Backward chaining (BC) / queries**  
   Koristi se kada sistem ili korisnik želi odgovor na konkretno pitanje i objašnjenje uslova. Primeri:
  - „Da li je bezbedno kućno praćenje?“
  - „Da li dete mora na urgentnu bolničku procenu?“
  - „Koji uslovi nisu ispunjeni da bi dete ostalo u niskom riziku?“

- **Complex Event Processing (CEP)**  
   Koristi se za obrasce koji imaju smisla tek kada se gleda tok događaja kroz vreme. Primeri:
  - više uzastopnih procena sa tahipnejom,
  - pad saturacije kroz nekoliko merenja,
  - pogoršanje rada disanja u zadatom vremenskom prozoru,
  - smanjeni unos tečnosti koji prati respiratorno pogoršanje.

- **Templates**
   Koriste se za grupe pravila iste strukture sa različitim parametrima. Primeri:
  - uzrasni pragovi za tahipneju i vitalne parametre,
  - modifikatori rizika po komorbiditetu i uzrastu,
  - mapiranje red flag znakova na nivo ozbiljnosti i preporučenu akciju.

- **Salience i prioriteti pravila**
  Koriste se da kritični znaci kao što su apneja, cijanoza ili konvulzije budu obrađeni pre manje hitnih pravila za rutinsku klasifikaciju.

- **Agenda grupe**
   Po potrebi se mogu odvojiti faze rada:
  - detekcija osnovnih kliničkih stanja,
  - obrada vremenskih obrazaca,
  - donošenje odluke o nivou rizika,
  - generisanje preporuke i objašnjenja.

**Kako se baza znanja popunjava**

- stalni deo baze znanja čine medicinska pravila, uzrasne tabele, red flag znakovi i šabloni pravila;
- promenljivi deo se puni unosom simptoma i merenja kroz korisnički interfejs ili API;
- klinički nalaz može unositi lekar, a deo opservacionih podataka može unositi roditelj ili staratelj;
- templates omogućavaju da se bez izmene koda menjaju uzrasne kategorije, pragovi i težine eskalacije.

**Kako se baza znanja koristi**

- `Forward chaining` izvodi činjenice kao što su:
  - `TachypneaDetected`
  - `WorkOfBreathingIncreased`
  - `HydrationConcern`
  - `GeneralDangerSignPresent`
  - `HypoxemiaConcern`
  - `HighRiskChildProfile`
  - `ClinicalReviewNeeded`
  - `UrgentReferralNeeded`

- `CEP` prati vremenske obrasce kao što su:
  - dve ili više uzastopne procene sa tahipnejom,
  - pad saturacije kroz više merenja,
  - pogoršanje rada disanja u prozoru od 6–24 sata,
  - smanjenje unosa tečnosti uz odsustvo mokrenja u definisanom prozoru,
  - ponavljanje alarma nakon prethodne procene niskog rizika.

- `Backward chaining` kroz upite odgovara na pitanja:
  - „Da li je bezbedno kućno praćenje?“
  - „Da li dete zahteva pregled istog dana?“
  - „Da li postoje razlozi za urgentno bolničko zbrinjavanje?“
  - „Koji uslovi nisu ispunjeni da bi dete ostalo u grupi niskog rizika?“

### 4.4 Konkretan primer zaključivanja, korak po korak

**Početno stanje**

- Dete: Ana, `10 meseci`
- Trajanje bolesti: `2 dana`
- Simptomi: kašalj, temperatura, otežano disanje
- Komorbiditeti: nema
- Početna odluka: aktivno kućno praćenje uz ponovnu procenu istog dana

**Unosi kroz dan**

- `09:00` — `RespiratoryAssessmentEvent`
  - temperatura `38.6 C`
  - respiratorna frekvenca `54/min`
  - saturacija `95%`
  - blago nazalno širenje
  - bez cijanoze
  - dete pije slabije nego obično

- `13:00` — `HydrationIntakeEvent`
  - procenjeni unos tečnosti oko `70%` uobičajenog
  - jedna mokra pelena manje nego obično

- `15:00` — `RespiratoryAssessmentEvent`
  - respiratorna frekvenca `58/min`
  - saturacija `94%`
  - nazalno širenje prisutno
  - uvlačenje donjeg dela grudnog koša prisutno
  - dete manje aktivno

- `19:00` — `RespiratoryAssessmentEvent`
  - respiratorna frekvenca `61/min`
  - saturacija `93%`
  - uvlačenje grudnog koša i dalje prisutno
  - unos tečnosti i dalje loš

**Trag zaključivanja**

1. **Nivo 1 (FC)**  
   Sistem na osnovu uzrasta `10 meseci` bira odgovarajuću uzrasnu grupu. Prag za brzo disanje po WHO pravilima za uzrast `2–11 meseci` je `>= 50/min`, pa se već na prvom merenju izvodi:
   - `TachypneaDetected(ageBand=2_11_MONTHS, rr=54)`

2. **Nivo 2 (FC)**  
   Po NICE kriterijumima za febrilno dete mlađe od 5 godina, saturacija `<= 95%`, nazalno širenje i uvlačenje grudnog koša predstavljaju značajne respiratorne znake. Posle drugog respiratornog unosa sistem izvodi:
   - `OxygenationConcern(spo2=94)`
   - `WorkOfBreathingIncreased(type=CHEST_INDRAWING_AND_NASAL_FLARING)`

3. **CEP — obrazac pogoršanja kroz vreme**  
   Pravilo `PersistentTachypneaTrend` gleda respiratorna merenja u kliznom prozoru od `12h`. Pošto su u više uzastopnih merenja prisutni:
   - tahipneja,
   - rast respiratorne frekvence,
   - pad saturacije sa `95%` na `94%` pa na `93%`,
   sistem ubacuje:
   - `RespiratoryDeteriorationPattern`

4. **CEP + hidracija**  
   Pravilo `ReducedIntakeWithRespiratoryIllness` povezuje respiratorne nalaze sa unosom tečnosti od približno `70%` uobičajenog. Na osnovu NICE bronchiolitis preporuka o neadekvatnom unosu tečnosti i kliničke procene rizika, sistem ubacuje:
   - `HydrationConcern(level=MODERATE)`

5. **Nivo 3 (FC)**  
   Pravilo `NeedSameDayEscalation` gleda:
   - `TachypneaDetected`
   - `WorkOfBreathingIncreased`
   - `OxygenationConcern`
   - `HydrationConcern`
   i izvodi:
   - `ClinicalReviewNeeded(urgency=SAME_DAY_OR_HIGHER)`

6. **Nivo 4 (FC)**  
   Pravilo `UrgentHospitalAssessmentFromTrend` gleda kombinaciju:
   - pogoršanja kroz vreme,
   - trajne tahipneje,
   - uvlačenja grudnog koša,
   - snižavanja saturacije,
   - smanjenog unosa tečnosti,
   pa izvodi:
   - `UrgentReferralNeeded(reason=RESPIRATORY_WORSENING_WITH_HYDRATION_CONCERN)`

7. **BC upit**  
   Kliničar ili sistem pita:
   - `isSafeForHomeMonitoring(childId, now)`

   Upit proverava da li su ispunjeni svi uslovi da dete ostane u grupi za kućno praćenje:
   - nema opšteg znaka opasnosti,
   - nema značajnog rada disanja,
   - nema zabrinjavajuće saturacije,
   - nema obrasca pogoršanja,
   - nema značajnog pada unosa tečnosti.

   Rezultat je: **NE**.

8. **Konačna preporuka**
   Sistem generiše:
   - `Recommendation(level=URGENT_HOSPITAL_ASSESSMENT)`
   - objašnjenje: dete ima uzrasno potvrđenu tahipneju, pogoršanje rada disanja, uzastopni pad saturacije i istovremeni problem sa unosom tečnosti.

Važno je da sistem ovde **ne tvrdi konačnu dijagnozu** „pneumonija“ ili „bronhiolitis“, već zaključuje da postoje znaci **pogoršanja respiratornog stanja** i da dete više nije pogodno za pasivno kućno praćenje.

### 4.5 Primeri složenih pravila

Pravila su ovde opisana u prozi. U implementaciji bi bila pretočena u DRL i prateće templates.

#### Pravilo 1 — Uzrasno zavisna detekcija tahipneje (template + FC)

**Ako** dete pripada uzrasnoj grupi `2–11 meseci` i respiratorna frekvenca je `>= 50/min`, **onda** sistem ubacuje `TachypneaDetected`.

**Ako** dete pripada uzrasnoj grupi `1–5 godina` i respiratorna frekvenca je `>= 40/min`, **onda** sistem ubacuje istu izvedenu činjenicu sa drugim parametrima.

Ovo je dobar primer za **template**, jer je struktura pravila ista, a menjaju se uzrasni opseg i prag.

#### Pravilo 2 — Obrazac pogoršanja respiratornog rada (CEP)

**Ako** se u prozoru od `12h` pojave najmanje `2` respiratorna merenja sa:

- tahipnejom za taj uzrast,
- i prisutnim nazalnim širenjem ili uvlačenjem grudnog koša,

**i** poslednje merenje pokazuje veći ili isti nivo opterećenja disanja nego prethodno, **onda** sistem ubacuje `RespiratoryDeteriorationPattern`.

Ovo pravilo koristi:

- vremenski prozor,
- povezivanje uzastopnih događaja,
- zaključivanje o trendu, a ne samo o jednom nalazu.

#### Pravilo 3 — Saturacioni alarm u kliničkom kontekstu (template + FC)

**Ako** postoji respiratorna infekcija i:

- saturacija `<= 95%` kod febrilnog deteta mlađeg od 5 godina, **onda** sistem ubacuje `OxygenationConcern(level=ELEVATED)`;
- saturacija je ispod kontekstualnog praga za težu bronhiolitis sliku ili hipoksemiju, **onda** sistem ubacuje `OxygenationConcern(level=HIGH)`.

Ova grupa pravila je pogodna za **template** jer pragovi zavise od kliničkog konteksta i uzrasta.

#### Pravilo 4 — Opšti znak opasnosti vodi u hitnu eskalaciju (FC sa visokim prioritetom)

**Ako** postoji bilo koji od sledećih znakova:

- nemogućnost pijenja ili dojenja,
- letargija ili poremećaj svesti,
- konvulzije,
- apneja,
- centralna cijanoza,

**onda** sistem odmah ubacuje:

- `GeneralDangerSignPresent`
- `EmergencyActionRequired`

Ovo pravilo ima vrlo visok prioritet jer ne treba da čeka dodatna niža pravila.

#### Pravilo 5 — Respiratorno pogoršanje udruženo sa smanjenim unosom tečnosti (CEP + FC)

**Ako** dete u toku praćenja ima:

- potvrđeni obrazac respiratornog pogoršanja,
- i unos tečnosti od `50%` do `75%` uobičajenog ili smanjeno mokrenje u relevantnom prozoru,

**onda** sistem podiže nivo preporuke sa običnog pregleda na viši nivo opreza, jer se respiratorni problem sada kombinuje sa mogućim poremećajem hidracije.

#### Pravilo 6 — Upit za bezbednost kućnog praćenja (BC)

Na pitanje:

- `isSafeForHomeMonitoring(childId)`

upit vraća odgovor **DA** samo ako su svi uslovi zadovoljeni:

- nema opšteg znaka opasnosti,
- nema hitnog respiratornog alarma,
- nema obrasca pogoršanja u definisanom vremenskom prozoru,
- nema zabrinjavajućeg pada unosa tečnosti,
- dete nije u visoko-rizičnoj grupi koja traži niži prag za eskalaciju.

Ako odgovor nije potvrdan, upit vraća i listu neuspelih uslova, čime se dobija objašnjenje odluke.

---

## 5. Arhitektura

### 5.1 Tehnologije

Predložena implementacija može koristiti:

- `Java 17`
- `Spring Boot`
- `Drools / KIE`
- `Maven`
- `Angular` ili drugi frontend po dogovoru tima
- relacijsku bazu za čuvanje korisnika, epizoda bolesti i audit zapisa

### 5.2 Modulna arhitektura

Predložena podela prati organizaciju koja je slična primerima sa vežbi:

- `model`
  - domenski modeli i događaji
  - `ChildProfile`
  - `RespiratoryAssessmentEvent`
  - `HydrationIntakeEvent`
  - `GeneralDangerSignEvent`
  - `RiskAssessment`
  - `Recommendation`

- `kjar`
  - DRL pravila
  - FC pravila
  - CEP pravila
  - BC upiti
  - templates i njihove tabele

- `service`
  - REST API
  - orkestracija sesija
  - mapiranje unosa u činjenice i događaje
  - čuvanje istorije i audit log-a

- `ui`
  - unos simptoma i merenja
  - prikaz aktivnih upozorenja
  - prikaz objašnjenja odluke
  - ekran za praćenje više aktivnih slučajeva

### 5.3 KIE sesije

Predlog je da sistem koristi najmanje dve glavne sesije:

- **Stateful FC sesija**
  - drži profil deteta i izvedene činjenice o trenutnoj epizodi,
  - služi za klasifikaciju rizika i generisanje preporuke.

- **Stateful CEP sesija u STREAM modu**
  - prati tok događaja kroz vreme,
  - otkriva pogoršanje, ponavljanje alarmantnih nalaza i kombinovane obrasce.

`BC` se realizuje kroz Drools queries nad relevantnim stanjem radne memorije, za pitanja tipa:

- da li je bezbedno kućno praćenje,
- da li postoje uslovi za urgentnu procenu,
- koji uslovi nisu zadovoljeni.

### 5.4 Demonstracija i validacija sistema

Da bi projekat bio proverljiv, sistem će se demonstrirati nad unapred pripremljenim scenarijima koji pokrivaju tipične i granične slučajeve. Primeri scenarija uključuju:

- dete sa blagim respiratornim simptomima bez znakova pogoršanja,
- dete sa uzrasno potvrđenom tahipnejom ali bez dodatnih red flag znakova,
- dete sa progresivnim padom saturacije i povećanjem rada disanja,
- dete sa respiratornim problemom i smanjenim unosom tečnosti,
- dete sa opštim znakom opasnosti koji mora odmah da aktivira hitnu eskalaciju.

Ispravnost sistema proveravaće se kroz:

- **unit testove pravila** za pojedinačne kliničke situacije,
- **CEP testove** za vremenske obrasce pogoršanja,
- **query testove** za pitanja tipa „da li je bezbedno kućno praćenje?“,
- proveru da li sistem za isti ulaz daje očekivanu i objašnjivu preporuku.

Na taj način se ne proverava samo da li sistem „radi“, već i da li:

- pravilno interpretira smernice,
- pravilno eskalira rizik,
- ne propušta kritične znakove,
- daje konzistentan lanac objašnjenja.

---

## 6. Šabloni (templates)

### 6.1 Šablon `AgeRespiratoryThreshold` — uzrasni pragovi za respiratornu procenu

**Svrha**: Pravila za tahipneju i deo vitalnih pragova razlikuju se po uzrastu. Umesto ručnog pisanja velikog broja pravila, pragovi se drže u tabeli.

**Parametri**:

- `ageBand`
- `minAgeMonths`
- `maxAgeMonths`
- `tachypneaThreshold`
- `tachycardiaThreshold` ako se koristi

**Primer tabele**:

```csv
ageBand,minAgeMonths,maxAgeMonths,tachypneaThreshold,tachycardiaThreshold
AGE_2_11_MONTHS,2,11,50,160
AGE_12_24_MONTHS,12,24,40,150
AGE_25_60_MONTHS,25,60,40,140
```

### 6.2 Šablon `EscalationRiskModifier` — faktori koji spuštaju prag za eskalaciju

**Svrha**: Neka deca imaju veći rizik od teškog toka bolesti i kod njih isti nalaz ne treba tumačiti isto kao kod potpuno zdravog deteta.

**Parametri**:

- `riskFactor`
- `requiresLowerEscalationThreshold`
- `note`

**Primer tabele**:

```csv
riskFactor,requiresLowerEscalationThreshold,note
YOUNG_INFANT_UNDER_3_MONTHS,true,Lower threshold for referral and observation
PREMATURITY,true,Clinical deterioration may develop faster
CHRONIC_LUNG_DISEASE,true,Higher risk of severe bronchiolitis or pneumonia course
HEMODYNAMIC_CONGENITAL_HEART_DISEASE,true,Higher risk group in NICE bronchiolitis guidance
IMMUNODEFICIENCY,true,Lower tolerance for home monitoring
NEUROMUSCULAR_DISORDER,true,Risk of secretion clearance problems
```

### 6.3 Šablon `RedFlagSeverity` — mapiranje znakova opasnosti na nivo reakcije

**Svrha**: Nisu svi alarmantni znaci iste težine. Neki zahtevaju pregled istog dana, a neki momentalnu hitnu reakciju.

**Parametri**:

- `flagType`
- `severity`
- `salienceLevel`
- `recommendedAction`

**Primer tabele**:

```csv
flagType,severity,salienceLevel,recommendedAction
APNEA,CRITICAL,10000,EMERGENCY_RESPONSE
CENTRAL_CYANOSIS,CRITICAL,10000,EMERGENCY_RESPONSE
CONVULSION,CRITICAL,10000,EMERGENCY_RESPONSE
UNABLE_TO_DRINK,CRITICAL,9500,URGENT_HOSPITAL_ASSESSMENT
LETHARGY_OR_REDUCED_CONSCIOUSNESS,CRITICAL,9500,URGENT_HOSPITAL_ASSESSMENT
SEVERE_CHEST_INDRAWING,HIGH,9000,URGENT_HOSPITAL_ASSESSMENT
GRUNTING,HIGH,9000,URGENT_HOSPITAL_ASSESSMENT
PERSISTENT_LOW_SATURATION,HIGH,9000,URGENT_HOSPITAL_ASSESSMENT
REDUCED_INTAKE_WITH_RESPIRATORY_DISTRESS,MEDIUM,7000,NEEDS_SAME_DAY_CLINICAL_REVIEW
```

Ovaj šablon je koristan zato što omogućava da sistem prvo obradi najopasnije znakove i da manje važna pravila ne prekriju kritičnu situaciju.
