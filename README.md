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

Vi har brukt git til å dokumentere arbeidet vårt. Vi har omtrent 84 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Ana har hatt hovedansvar for oppgave 1, 4, og 7. 
* Øyvind har hatt hovedansvar for oppgave 2, 5, og 8. 
* Mark har hatt hovedansvar for oppgave 3, 6 og 9. 
* Vi har i fellesskap løst oppgave 10. 

# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

* Oppgave 1: Etter flere feilet forsøk, fant jeg denne versjon av konstruktoren som endelig fungerte. 
             Oppgaven ble løst med å først finne den først non-null verdien og da begynne å lage den første noden.
             Hoden ble lenket til denne første noden og deretter ble alle andre noder laget hvis verdien innehaldt i indeksen ikke var null.
             Når alle noder ble laget, da ble hale knyttet til den siste noden.
             Siden antall noder ble oppdatert inn i konstruktoren (eller leggTil() metoden), antall() metode var enkelt: bare returnere antall.
             Metoden tom() bare sjekket om antall er lik 0 og returnerte true (hvis ja) og false (hvis ikke).

* Oppgave 2: Løste oppgave 2a ved å bruke en StringBuilder. Valgte å appende en "[" før if-setningen og en "]" etter if-setningen. 
             Inni if-setningen går man gjennom node for node med neste pekere og legger til verdiene med komma og mellomrom mellom dem. Akkurat samme metode for omvendtString() 
             bare at vi bruker hale som første verdi og forrige pekere. For 2b gjorde jeg klart for to muligheter, at verdien legges inn foran hvis antall er 0 eller bak hvis den 
             ikke er det. Hvis den legges inn foran er listen tom og det lages en ny node uten forrige og neste pekere. Hvis den legges inn bak vil den nye noden ha den tidligere 
             siste verdien som sin forrige verdi, og hale vil få en ny forrige verdi. Den tidligere forrige verdien må også få den nye verdien som sin neste verdi.
             
* Oppgave 3: Løste finnNode(indeks) med hensyn til performance. Så lagt inn enn en sjekk om systemet måtte sjekke fra hode eller fra hale. 
             Med hent hadde jeg mer problemer siden indeksKontroll() tok så lang tid. Fant en grei løsning på det etterhvert som sørget for at hastigheten var innefor.
             Oppdater() var ganske rett fram.
             subliste() var mye trial and erorr. Til slutt valgte jeg å bruke en Node liste samt med en for loop og bruk av finnNode og leggInn metodene. Som gjorde funksjonen till grei og lesbart.

* Oppgave 4: Løste inneholder()  og indexTil() ved å, først sjekke om listen var tom eller verdien var null. Om ja, da returnerte den automatisk false eller -1. 
             Ellers, var en hjelpevariabel (node p), som begynte som den første noden i listen, laget og verdien ble sjekket mot p.verdi.
             I indexTil() er det også en andre hjelpevariabel (som skal fakstisk returneres i noe tilfeller), index. 
             Den blir oppdatert (+1) hver gang verdien er ikke lik p.verdi, og returneres når de er like. Om det er ingen match, da returneres det -1.
             Om verdien var den samme, returnerte metoden true. Ellers, ble p oppdatert til p.neste og while-loop'en fortsatte å kjøre til p ble null eller verdien ble fant.
             For inneholder, likhet ble sjekket i en like måte. Om det ble funnet, da returnerte metoden true. Ellers, false.
              

* Oppgave 5: Løste oppgaven ved å først tenke ut alle alternativer vi har, at den skal legges inn først når antall = 0 og først når antall er hva som helst annet - at den skal legges 
             inn til slutt eller mellom to noder. Så brukte jeg lang tid på å tenke ut akkurat hva som må gjøres for å sette riktige forrige og neste verdier i alle situasjonene. 
             Hjelpeverdier for de forskjellige nodene hjalp mye. Hadde skrevet denne koden tidligere der hode og hale hadde egne verdier (det samme gjorde jeg i de andre oppgavene) 
             så jeg måtte endre hele oppgaven for å fikse det, men det gikk til slutt. Brukte forrsten Objects.requireNonNull (som jeg lærte fra kompendiet) for å stoppe innlegging av null-verdier, 
             det samme gjorde jeg ovenfor i oppgave 2.
             
* Oppgave 6: Denne oppgaven var ganske ok men hadde noe problemer med pekere. Måtte til slutt skrive ned hva som skjedde i funksjonen som hjalp mye.
             Etter at jeg har gått gjennom alt med pen og papir ble testen også godkjennt med det samme :).

* Oppgave 7: Første måte ble laget ved å lage et hjelpevariabel (Node p) som tok inn den første noden i listen.
             Om denne noden ikke var null, da gikk variabelen inn i en for loop hvor p ble oppdatert til den neste noden, og gammel p (nå p.forrige) verdiene ble satt til null.
             Endelig, ble den siste p slettet.
             Den andre måte ble løst ved å lage en hjelpevariabel som holdt verdien til antall (slik at den ikke ble endret i for-loopen når en node ble slettet).
             Inn i en for-loop, ble hver node slettet ved å kalle slett(0). 

* Oppgave 8: Oppgave a: Jeg gjorde akkurat som oppgaven sa, kastet en exception hvis iteratorendringer ikke er lik endringer og en annen exception hvis hasNext ikke er sann. Så omgjøres fjernOK til true, sånn at 
             remove() metoden kan fjerne noe. Deretter blir denne omgjort til denne.neste (fordi første verdi = hode og hode.verdi = null) hvis ikke denne.neste.neste = null, da er denne = null for at next() ikke skal kalles igjen. 
             Verdien til denne blir lagret i en ny variabel, som så blir returnert. 8b er enkel, det er bare å instansiere en ny type av klassen DobbeltLenketListeIterator. 8c gjorde jeg ved å starte 
             med en indeksKontroll, så bruker jeg metoden finnNode med indeks-1 som parameter for at denne skal peke på riktig indeks. Etter det så instansieres enkelt og greit fjernOK og iteratorendringer. 
             Og i metoden iterator(int indeks) trenger jeg bare å returnere en ny DobbeltLenketListeIterator(indeks).
             
* Oppgave 9: Startet med å kaste exceptions, deretter blir fjernOK false igjen. Så må jeg gjøre rede for alle mulige verdier som kan bli slettet, den første i listen (en if for antall = 1 og en else for alle andre verdier av antall), 
             den siste og alle i mellom de to. Det vanskeligste var å linke den med next() metoden som var litt innviklet. Til slutt legger vi til en endring/iteratorendring og tar bort 1 fra antall.

* Oppgave 10: Startet med å lage en selection sort metode, for den laget vi en ekstra metode som finner minste verdi sin indeks og bruker den indeksen 
              i for-løkken for å sette minste verdi først. Bruker metodene hent() og oppdater() ettersom vi ikke kan gjøre ting som a[i] osv. Laget også en 
              bubble-sort metode der det største tallet blir lagt bakerst, først var den uoptimalisert og gikk gjennom hele listen hele tiden men når vi la til
              en variabel som reduserte listens lengde og ikke gikk gjennom de tallene som allerede er satt bakerst ble det mye kjappere.
              Vi valgte å gå for bubble-sort av de vi lagde, den var mye mer effektiv.

