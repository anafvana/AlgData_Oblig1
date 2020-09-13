import java.lang.UnsupportedOperationException;
import java.util.*;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
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
        //TODO Ask about this exception in lab
        //throw new UnsupportedOperationException();
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

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
    }

    //TODO Fix
    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
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
    }

    //Inspirert av pensum, Programkode 1.3.9 a)
    //Tom Scott https://www.youtube.com/watch?v=RGuJga2Gl_k (05:53)
    //og HackerRank https://www.youtube.com/watch?v=SLauY6PpjW4
    /*public static void innsettningsortering(int[] a, int fra, int til) {
        for (int i = fra + 1; i < til; i++) {
            int j = i - 1;
            try {
                while (a[i] < a[j] && j >= fra) {
                    bytt(a, i, j);
                    i--;
                    j--;
                }
            } catch (IndexOutOfBoundsException e) {
            }
        }
    }*/

    public static void quicksort(int[] a){
        quicksort(a, 0, a.length-1);
    }

    private static void quicksort(int[] a, int v, int h){
        if (v >= h) return;

        int pivot = a[v + (h - v)/2]; //sets pivot to half the current array, considering possibility of overflow (Inspired on Emily Björk's comment on HackerRank's video)
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
                }
            }
        }
        return out.toString();
    }

    //TODO FIX
    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] temp = new int[a.length];

        //Hjelpetabell
        System.arraycopy(a, 0, temp, 0, a.length);

        int[] indeks = new int[a.length];
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

        return indeks;
    }

    //TODO Fix
    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {

        if (a.length < 3) throw new NoSuchElementException("Tabellen har mindre enn 3 verdier");

        int forstMin = a[0];
        int andreMin = a[1];
        int tredjeMin = a[2];

        if (forstMin > andreMin) {
            int temp = andreMin;
            andreMin = forstMin;
            forstMin = temp;
        }
        if (andreMin > tredjeMin) {
            if (forstMin > tredjeMin) {
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
            if (tempLoop < tredjeMin) {
                if (tempLoop < andreMin) {
                    tredjeMin = andreMin;
                    if (tempLoop < forstMin) {
                        andreMin = forstMin;
                        forstMin = tempLoop;
                    } else {
                        andreMin = tempLoop;
                    }
                } else {
                    tredjeMin = tempLoop;
                }
            }
        }
        return new int[]{forstMin, andreMin, tredjeMin};
    }

    //TODO Fix
    ///// Oppgave 10 //////////////////////////////////////

    //TODO Add?
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        boolean inneholdt = false;
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();

        for (int i = 0; i < b.length(); i++) {
            if (bMap.containsKey(b.charAt(i))) {
                int count = bMap.get(b.charAt(i));
                bMap.put(b.charAt(i), count + 1);
            } else {
                bMap.put(b.charAt(i), 1);
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if (bMap.containsKey(a.charAt(i))) {
                if (aMap.containsKey(a.charAt(i))) {
                    int count = aMap.get(a.charAt(i));
                    aMap.put(a.charAt(i), count + 1);
                } else {
                    aMap.put(a.charAt(i), 1);
                }
            } else {
                return inneholdt;
            }
        }

        Iterator aMapIterator = aMap.entrySet().iterator();

        while (aMapIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) aMapIterator.next();
            Character sjekkCharacter = (Character) mapElement.getKey();
            int AmapVerdie = aMap.get(sjekkCharacter);
            int BmapVerdie = bMap.get(sjekkCharacter);
            if (AmapVerdie <= BmapVerdie) {
                inneholdt = true;
            } else {
                return false;
            }
        }

        return inneholdt;
    }
}  // Oblig1