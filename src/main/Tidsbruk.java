import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tidsbruk {
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n) {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
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

    public static void delsortering1(int[] a){
        int j = a.length - 1;

        if (j > 0) {
            int lastOdd = 0;
            for (int i = 0; i < a.length; i++) {
                int iFokus = a[i];

                if (iFokus % 2 == 0) {
                    if (j == i) {
                        break;
                    }
                    while (a[j] % 2 == 0 && j > i) {
                        j--;
                    }
                    a[i] = a[j];
                    a[j] = iFokus;
                    i--;
                } else {
                    lastOdd = i;
                }
            }
            innsettningsortering(a, 0, lastOdd + 1);
            innsettningsortering(a, lastOdd + 1, a.length);
        }
    }

    //Inspirert av pensum, Programkode 1.3.8 e) og Tom Scott https://www.youtube.com/watch?v=RGuJga2Gl_k (04:43)
    public static void innsettningsortering(int[] a, int fra, int til){
        for (int i = fra+1; i<til; i++){
            int j = i-1;
            try {
                while (a[i] < a[j] && j >= fra) {
                    bytt(a, i, j);
                    i--;
                    j--;
                }
            } catch (IndexOutOfBoundsException e){
            }
        }
    }

    public static int kostnader(int[] a) {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}  // en tom blokk
        return m;
    }

    public static int maks(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt!");
        } else {
            for(int i = 1; i < a.length; i++) {
                int forste = a[i-1];
                int neste = a[i];
                if(forste > neste) {
                    a[i] = forste;
                    a[i-1] = neste;
                }
            }
            return a[a.length-1];
        }
    }

    public static int maks1(int[] a) {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    }

    public static int maks2(int[] a) {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    }

    public static int maks3(int[] a) {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Arrayet er tom!");

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

    public static void main(String ... args) {
        int n = 1000, antall = 2000; // tabellstørrelse og gjentagelser
        long tid;                    // for tidsmåling
        int[] a = randPerm(n);           // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks1(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();
        for(int i = 0; i < antall; i++) maks(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Maks-metoden fra Oblig1: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) delsortering(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Delsortering-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) delsortering1(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Delsortering1-metoden: " + tid + " millisek");
    }
}
