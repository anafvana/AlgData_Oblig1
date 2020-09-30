# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 

# Krav til innlevering

Se oblig-tekst for alle krav. Oppgaver som ikke oppfyller følgende vil ikke få godkjent:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* Ingen debug-utskrifter
* Alle testene som kreves fungerer (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet

# Arbeidsfordeling

Oppgaven er levert av følgende studenter:
* Ana Flávia Vital - s344046@oslomet.no
* Mark van der Baan - s344105@oslomet.no
* Øyvind Ødegård Stenberg - s188886@oslomet.no

Vi har brukt git til å dokumentere arbeidet vårt. Vi har 16 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Ana har hatt hovedansvar for oppgave 1, 4, og 7. 
* Øyvind har hatt hovedansvar for oppgave 2, 5, og 8. 
* Mark har hatt hovedansvar for oppgave 3, 6 og 9. 
* Vi har i fellesskap løst oppgave 10. 

# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

* Oppgave 1: Løste ved å implementere..

* Oppgave 2: Løste oppgave 2a ved å bruke en StringBuilder. Valgte å appende en "[" før if-setningen og en "]" etter if-setningen. 
             Inni if-setningen går man gjennom node for node med neste pekere og legger til verdiene med komma og mellomrom mellom dem. Akkurat samme metode for omvendtString() 
             bare at vi bruker hale som første verdi og forrige pekere. For 2b gjorde jeg klart for to muligheter, at verdien legges inn foran hvis antall er 0 eller bak hvis den 
             ikke er det. Hvis den legges inn foran er listen tom og det lages en ny node uten forrige og neste pekere. Hvis den legges inn bak vil den nye noden ha den tidligere 
             siste verdien som sin forrige verdi, og hale vil få en ny forrige verdi. Den tidligere forrige verdien må også få den nye verdien som sin neste verdi.
             
* Oppgave 3: 

* Oppgave 4: 

* Oppgave 5: Løste oppgaven ved å først tenke ut alle alternativer vi har, at den skal legges inn først når antall = 0 og først når antall er hva som helst annet - at den skal legges 
             inn til slutt eller mellom to noder. Så brukte jeg lang tid på å tenke ut akkurat hva som må gjøres for å sette riktige forrige og neste verdier i alle situasjonene. 
             Hjelpeverdier for de forskjellige nodene hjalp mye. Hadde skrevet denne koden tidligere der hode og hale hadde egne verdier (det samme gjorde jeg i de andre oppgavene) 
             så jeg måtte endre hele oppgaven for å fikse det, men det gikk til slutt. Brukte forrsten Objects.requireNonNull (som jeg lærte fra kompendiet) for å stoppe innlegging av null-verdier, 
             det samme gjorde jeg ovenfor.
             
* Oppgave 6:

* Oppgave 7:

* Oppgave 8: Løste oppgave 8a på en måte som kanskje ikke er lov i forhold til oppgaveteksten. Jeg endret verdien i konstruktøren til å være denne = hode.neste ettersom denne=hode fungerte med min gamle 
             kode men ikke den nye der hode og hale ikke har egne verdier. Der etter gjorde jeg akkurat som oppgaven sa, kaste exception hvis iteratorendringer ikke er lik endringer og en annen exception 
             hvis hasNext ikke er sann. Deretter omgjøres fjernOK til true, sånn at remove() metoden kan fjerne noe. Så lagret jeg denne.verdi i en tempVerdi og flyttet denne til neste element via 
             denne = denne.neste og returnerte tempVerdi. 8b var enkel, det var bare å instansiere en ny DobbeltLenkeltListeIterator. 8c løste jeg ved å ta indeksKontroll først, for så å bruke metoden 
             finnNode(indeks) som vi tidligere har laget. Så koden ble da denne = finnNode(indeks). De andre variablene fjernOK og iteratorendringer ble instansiert på vanlig måte.
             
* Oppgave 9:

* Oppgave 10:

