import java.lang.UnsupportedOperationException;
import java.util.*;

public class Oblig1 {
    private Oblig1() {}

    // Øyvind Ødegård Stenberg - s188886
    // Ana Flávia Vital - s344046
    // Mark van der Baan - s344105

    ///// Oppgave 1 //////////////////////////////////////
    // Spoersmaal etter oppgave 1:
    // Spm: Naar blir det flest ombyttinger?
    // Svar: Det blir flest ombyttinger naar det stoerste tallet er foerst.
    // Spm: Naar blir det faerrest?
    // Svar: Naar arrayet er sortert stigende.
    // Spm: Hvor mange blir det i gjennomsnitt?
    // Svar: Det blir i gjennomsnitt 1/2 + 1/3 + 1/4 + 1/5 + ... + 1/n (Hn - 1) antall ganger vi gaar inn i if setningen. Denne rekken er Hn som er nesten det samme som log(n) + 0.577.
    //       Hvis n i vaart eksempel er 1 000 000 000 saa gaar vi inn i if setningen i gjennomsnitt log(1000000000) + 0.577 ganger, som er 9.577.
    public static int maks(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Arrayet er tomt!");

        int storste;
        int neste;
        for (int i = 1; i < a.length; i++) {
            storste = a[i - 1];
            neste = a[i];
            if (storste > neste) {
                // Dersom stoerste er stoerre enn det neste tallet bytter de plass
                // Slik at det stoerste tallet kommer paa siste plass
                a[i] = storste;
                a[i - 1] = neste;
            }
        }
        return a[a.length - 1];
    }

    //Oppgave 1 - Telle antall ombyttinger

    // Spoersmaal til ombyttingsoppgaven:
    // Lag tilfeldige permutasjoner av tallene fra 1 til n og bruk saa metoden.
    // Paa den maaten kan du faa en indikasjon paa hvor mange det blir i gjennomsnitt (det finnes en formel for gjennomsnittet).
    // Kan du paa grunnlag av dette si om metoden maks er bedre (eller daarligere) enn de maks-metodene vi har sett paa tidligere?

    // Svar: Denne maks-metoden vil vaere daarligere. Vi looper gjennom for-loekken 2n ganger, men for if testen vil vi gaa inn her
    // 4(n-1) ganger. Noe som gjoer hele metoden mye tregere enn de forrige maks metodene. Med tilfeldige permutasjoner
    // av tall fra f.eks 1-100 ble resultatet nesten alltid 90+ ombyttinger. Dette viser ogsaa at metoden er mye tregere.
    // Vi la til maks-metoden i Program klassen fra pensum, og det tok rundt 270 millisek aa utfoere den.
    // De tre andre maks-metodene vi har sett paa i pensum tok fra 85-40 millisek. Saa denne metoden er definitivt betydelig tregere.

    public static int ombyttinger(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Arrayet er tomt!");

        int antall = 0;

        for (int i = 1; i < a.length; i++) {
            int v1 = a[i - 1];
            int v2 = a[i];
            if (a[i - 1] > a[i]) {
                a[i - 1] = v2;
                a[i] = v1;
                antall++;
            }
        }
        return antall;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antall = 0;

        if (a.length > 0) {
            //Dersom arrayet ikke er tomt starter antall med 1 pga det foerste tallet
            antall++;
        } else {
            //Arrayet er tomt og vi returnerer 0
            return antall;
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                throw new IllegalStateException("Arrayet er ikke sortert i stigende rekkefoelge!");
            }
            if (a[i - 1] < a[i]) {
                antall++;
            }
        }

        return antall;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int antall = 0;
        for (int i = 0; i < a.length; i++) {
            boolean matches = false;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    matches = true;
                    break;
                }
            }
            if (!matches) antall++;
        }
        return antall;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int oddetall = 0;
        int partall = a.length-1;

        while(oddetall < partall){
            if(a[oddetall] % 2 == 0){
                if(a[partall] % 2 != 0){
                    int temp = a[partall];
                    a[partall] = a[oddetall];
                    a[oddetall] = temp;
                } else {
                    partall --;
                }
            } else {
                oddetall++;
            }
        }

        if (oddetall > 0){
            if(oddetall + 1 == a.length){
                quicksort(a);
            } else {
                quicksort(a, 0, oddetall -1);
            }
        }

        if(partall < a.length-1){
            quicksort(a, partall, a.length-1);
        }

        /*
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
            if (lastOdd == 0 || lastOdd == a.length - 1){
                quicksort(a);
            } else {
                quicksort(a, 0, lastOdd);
                quicksort(a, lastOdd + 1, a.length-1);
            }
        }
        */
    }

    //Inspirert av pensum, Programkode 1.3.9 a)
    //Tom Scott https://www.youtube.com/watch?v=RGuJga2Gl_k (05:53)
    //og HackerRank https://www.youtube.com/watch?v=SLauY6PpjW4
    public static void quicksort(int[] a){
        quicksort(a, 0, a.length-1);
    }

    private static void quicksort(int[] a, int v, int h){
        if (v >= h) return;

        int pivot = a[v + (h - v)/2]; //pivot blir midten av delarrayet, med haandtering av overflow risiko (Inspirert av Emily Björk's kommentar på HackerRanks video)
        int m = partition(a, v, h, pivot);
        quicksort(a, v, m-1);
        quicksort(a, m, h);
    }

    private static int partition(int[] a, int v, int h, int pivot){
        while(v <= h){
            while (a[v]<pivot) v++;
            while (a[h]>pivot) h--;

            if(v<=h){
                bytt(a, v, h);
                v++;
                h--;
            }
        }
        return v;
    }

    //Fra pensum, Programkode 1.1.8 d)
    public static void bytt(int[] a, int posA, int posB) {
        int temp = a[posA];
        a[posA] = a[posB];
        a[posB] = temp;
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        int maxLen = a.length - 1;

        if (maxLen > 0) {
            char temp = a[maxLen];

            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void reverser(char[] a, int start, int slutt) {
        while (start < slutt) {
            char temp = a[start];
            a[start] = a[slutt];
            a[slutt] = temp;
            start++;
            slutt--;
        }
    }

    public static void rotasjon(char[] a, int k) {
        int slutt = a.length-1;
        if(a.length != 0) {							// hvis arrayet er tomt - ikke gjør noe
            if(k < 0) {								// hvis k er et negativt tall, roter mot (reverser mot/fra) høyre med a.length - k
                k = -k % a.length;
                k = a.length - k;
            }
            k = k % a.length;
            reverser(a, 0, slutt);				// reverserer hele arrayet
            reverser(a, 0, k-1);			// reverserer første delen av arrayet frem til k
            reverser(a, k, slutt);					// reverserer andre delen av arrayet fra og med k til slutten
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() || i < t.length(); i++) {
            if (i < s.length()) {
                sb.append(s.charAt(i));
            }
            if (i < t.length()) {
                sb.append(t.charAt(i));
            }
        }
        return sb.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        int longest = 0;
        for (String str : s) {
            if (str.length() > longest) {
                longest = str.length();
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < longest; i++) {
            for (String str : s) {
                try {
                    out.append(str.charAt(i));
                } catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
        }
        return out.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] temp = new int[a.length];

        //Hjelpetabell
        System.arraycopy(a, 0, temp, 0, a.length);

        int[] indeks = new int[a.length];
        if (a.length > 0) {
            int lavesteverdi = a[0];
            int indeksLavesteVerdi = 0;

            for (int i = 0; i < indeks.length; i++) {
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
        }
        return indeks;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {

        if (a.length < 3) throw new NoSuchElementException("Tabellen har mindre enn 3 verdier");

        int forstMin = 0;
        int andreMin = 1;
        int tredjeMin = 2;

        if (a[forstMin] > a[andreMin]) {
            int temp = andreMin;
            andreMin = forstMin;
            forstMin = temp;
        }
        if (a[andreMin] > a[tredjeMin]) {
            if (a[forstMin] > a[tredjeMin]) {
                int temp1 = tredjeMin;
                tredjeMin = andreMin;
                andreMin = forstMin;
                forstMin = temp1;
            } else {
                int temp2 = tredjeMin;
                tredjeMin = andreMin;
                andreMin = temp2;
            }
        }

        for (int i = 3; i < a.length; i++) {
            int tempLoop = a[i];
            if (tempLoop < a[tredjeMin]) {
                if (tempLoop < a[andreMin]) {
                    tredjeMin = andreMin;
                    if (tempLoop < a[forstMin]) {
                        andreMin = forstMin;
                        forstMin = i;
                    } else {
                        andreMin = i;
                    }
                } else {
                    tredjeMin = i;
                }
            }
        }
        return new int[]{forstMin, andreMin, tredjeMin};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int[] bokstavTeller(String str) {
        int[] allChars = new int[39];

        char string36 = 'Å';
        int verdiString36 = 36;

        char string37 = 'Æ';
        int verdiString37 = 37;

        char string38 = 'Ø';
        int verdiString38 = 38;

        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) == string36){
                allChars[verdiString36] ++;
            } else if(str.charAt(i) == string37){
                allChars[verdiString37] ++;
            } else if(str.charAt(i) == string38){
                allChars[verdiString38] ++;
            } else {
                allChars[Character.getNumericValue(str.charAt(i))]++;
            }
        }
        return allChars;
    }

    public static boolean inneholdt(String a, String b) {
        int[] stringA = bokstavTeller(a);
        int[] stringB = bokstavTeller(b);

        for(int i=0; i < stringA.length; i++){
            if(stringA[i] > stringB[i]){
                return false;
            }
        }
        return true;
    }
}