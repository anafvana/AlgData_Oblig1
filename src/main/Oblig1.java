import java.util.NoSuchElementException;

public class Oblig1 {
    // Øyvind Ødegård Stenberg - s188886
    // Ana Flávia Vital - s344046
    // Mark van der Baan - s344105

    //Oppgave 1 - finne største tall
    // Spørsmål etter oppgave 1:
    // Spm: Når blir det flest ombyttinger?
    // Svar: Det blir flest ombyttinger når det største tallet er først.
    // Spm: Når blir det færrest?
    // Svar: Når det største tallet er sist.
    // Spm: Hvor mange blir det i gjennomsnitt?
    // Svar: Det blir i gjennomsnitt 1/2 + 1/3 + 1/4 + 1/5 + ... + 1/n antall ganger vi går inn i if setningen. Denne rekken er Hn som er nesten det samme som log(n) + 0.577.
    //       Hvis n i vårt eksempel er 1 000 000 000 så går vi inn i if setningen i gjennomsnitt log(1000000000) + 0.577 ganger, som er 9.577.
    public static int maks(int[] a) {
        sjekkArray(a);
        int storste;
        int neste;
        for(int i = 1; i < a.length; i++) {
            storste = a[i-1];
            neste = a[i];
            if(storste > neste) {
                // Dersom storste er større enn neste tallet bytter de plass
                // Slik at det største tallet kommer på siste plass
                a[i] = storste;
                a[i-1] = neste;
            }
        }
        return a[a.length-1];

        /*
        int storste = a[0];
        for(int i = 1; i < a.length; i++) {
            if(storste < a[i]) {
                storste = a[i];
            }
        }
        return storste;

         */




    }

    //Oppgave 1 - Telle antall ombyttinger
    // Spørsmål til ombyttingsoppgaven:
    // Lag tilfeldige permutasjoner av tallene fra 1 til n og bruk så metoden.
    // På den måten kan du få en indikasjon på hvor mange det blir i gjennomsnitt (det finnes en formel for gjennomsnittet).
    // Kan du på grunnlag av dette si om metoden maks er bedre (eller dårligere) enn de maks-metodene vi har sett på tidligere?
    // Svar: Ombyttingsmetoden vil være dårligere. Vi looper gjennom for løkken n ganger, men for if testen vil vi gå inn her
    // veldig mange flere ganger enn det harmoniske tallet Hn, så vi kommer til å gå inn i if setningen mye oftere.
    public static int ombyttinger(int[] a) {
        sjekkArray(a);

        int antall = 0;

        for (int i=1; i<a.length; i++){
            int v1 = a[i-1];
            int v2 = a[i];
            if (a[i-1]>a[i]) {
                a[i-1] = v2;
                a[i] = v1;
                antall++;
            }
        }
        return antall;
    }

    //VI TRENGER Å SVARE SPØRSMÅL ENDA

    public static void sjekkArray(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Arrayet er tom!");
    }

    //Oppgave 2 - antall ulike (sortert)
    public static int antallUlikeSortert(int[] a) throws IllegalStateException{
        int antall = 0;

        if(a.length > 0) {
            //Dersom arrayet ikke er tom starter antall med 1 pga første tallet
            antall ++;
        } else {
            //Arrayet er tomt og retuneres 0
            return antall;
        }

        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) {
                throw new IllegalStateException("Arrayet er ikke sortert i stigende rekkefølge!");
            }
            if(a[i-1] < a[i]) {
                antall++;
            }
        }

        return antall;
    }

    //Oppgave 3 - antall ulike (usortert)
    public static int antallUlikeUsortert(int[] a){
        int antall = 0;
        for (int i=0; i < a.length; i++){
            boolean matches = false;
            for (int j=0; j < i; j++){
                if (a[i] == a[j]) {
                    matches = true;
                    break;
                }
            }
            if (!matches) antall++;
        }
        return antall;
    }

    //Oppgave 4 - Delsortering
    public static void delsortering(int[] a){
        int temp;

        for(int i = 0; i < a.length; i++) {
            //Sjekk om tallet er et partall
            if (a[i] % 2 == 0) {
                for(int j = i+1; j < a.length; j++){
                    //Finn et oddetall for å bytte plass med partallet
                    if (a[j] % 2 != 0) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        break;
                    }
                }
            }
        }

        for(int i=0; i<a.length;i++) {
            if (a[i] % 2 != 0) {
                for(int j = 0; j < a.length; j++){
                    if (a[j] % 2 != 0 && a[j] != a[i] && a[j] > a[i]){
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        i--;
                        if(i < 0){
                            i = 0;
                        }
                        break;
                    }
                }
            }
            if (a[i] % 2 == 0) {
                for(int j = 0; j < a.length; j++){
                    if (a[j] % 2 == 0 && a[j] != a[i] && a[j] > a[i]){
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        i--;
                        if(i < 0){
                            i = 0;
                        }
                        break;
                    }
                }
            }
        }
    }

    //Oppgave 5 - rotasjon
    public static void rotasjon(char[] a){
        int maxLen = a.length - 1;

        if (maxLen > 0) {
            char temp = a[maxLen];

            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
    }

    //Oppgave 6 - Rotere flere plasser
    public static void rotasjonFlerePlasser(char[] a, int k) {
        if(k < 0) {
            // Omgjør tallet fra positivt til negativt og tar modulo på arrayet sitt lengde.
            // Dette for å finne forskjellen på lengden til arrayet og tallet. Så vi vet hvor langt arrayet skal roteres til venstre.
            // Vi gjør da så lengden på den første for-løkken blir så lang som vi vil rotere arrayet. Hvis lengden på arrayet er f.eks 10
            // vil en k verdi med -4 bli til 6, så i stedet for å rotere 4 ganger til venstre roterer vi heller 6 ganger til høyre.
            k = -k % a.length;
            k = a.length - k;
        }
        for(int i = 0; i < k; i++) {
            char siste = a[a.length-1];
            for(int j = a.length-1; j > 0; j--) {
                a[j] = a[j-1];
            }
            a[0] = siste;
        }
    }

    //Oppgave 7a - Fletting - Øyvinds forsøk
    public static String flett(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() || i < t.length(); i++) {
            if(i < s.length()) {
                sb.append(s.charAt(i));
            }
            if(i < t.length()) {
                sb.append(t.charAt(i));
            }
        }
        return sb.toString();
    }

    //Oppgave 7b - Fletting - Øyvinds forsøk (det fungerer men det er veldig dårlig :D)
    public static String flettArray(String... s) {
        StringBuilder kombinert = new StringBuilder();
        StringBuilder kombinert2 = new StringBuilder();
        StringBuilder kombinert3 = new StringBuilder();
        StringBuilder kombinert4 = new StringBuilder();
        StringBuilder kombinert5 = new StringBuilder();
        StringBuilder kombinert6 = new StringBuilder();
        StringBuilder kombinert7 = new StringBuilder();

        for(int i = 0; i < s.length; i++) {
            for(int j = 0; j < s[i].length(); j++) {
                kombinert.append(s[i].charAt(j));
                break;
            }
            for(int j = 1; j < s[i].length(); j++) {
                kombinert2.append(s[i].charAt(j));
                break;
            }
            for(int j = 2; j < s[i].length(); j++) {
                kombinert3.append(s[i].charAt(j));
                break;
            }
            for(int j = 3; j < s[i].length(); j++) {
                kombinert4.append(s[i].charAt(j));
                break;
            }
            for(int j = 4; j < s[i].length(); j++) {
                kombinert5.append(s[i].charAt(j));
                break;
            }
            for(int j = 5; j < s[i].length(); j++) {
                kombinert6.append(s[i].charAt(j));
                break;
            }
            for(int j = 6; j < s[i].length(); j++) {
                kombinert7.append(s[i].charAt(j));
                break;
            }
        }
        return kombinert.toString()+kombinert2.toString()+kombinert3.toString()+kombinert4.toString()+kombinert5.toString()+kombinert6.toString()+kombinert7.toString();
    }

    //Oppgave 8 - Indeks-sortering
    public static int[] indekssortering(int[] a){
        int [] temp = new int [a.length];

        //Hjelpe tabell
        System.arraycopy(a, 0, temp, 0, a.length);

        int[] indeks = new int [a.length];
        int lavesteverdi = a[0];
        int indeksLavesteVerdi = 0;

        for(int i = 0; i < indeks.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (lavesteverdi > temp[j]) {
                    lavesteverdi = temp[j];
                    indeksLavesteVerdi = j;
                }
            }
            indeks[i] = indeksLavesteVerdi;

            //Verdiene som er tatt vil bli satt til maks
            temp[indeksLavesteVerdi] = 0x7fffffff;
            lavesteverdi = 0x7fffffff;
        }

        return indeks;
    }

    //Oppgave 9 - Tredje minste tall


    //Oppgave 10 - Inneholdt

}