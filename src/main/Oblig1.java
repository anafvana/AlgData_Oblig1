import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

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
    }

    //Oppgave 1 - Telle antall ombyttinger

    // Spørsmål til ombyttingsoppgaven:
    // Lag tilfeldige permutasjoner av tallene fra 1 til n og bruk så metoden.
    // På den måten kan du få en indikasjon på hvor mange det blir i gjennomsnitt (det finnes en formel for gjennomsnittet).
    // Kan du på grunnlag av dette si om metoden maks er bedre (eller dårligere) enn de maks-metodene vi har sett på tidligere?

    // Svar: Denne maks-metoden vil være dårligere. Vi looper gjennom for-løkken 2n ganger, men for if testen vil vi gå inn her
    // 4(n-1) ganger. Noe som gjør hele metoden mye tregere enn de forrige maks metodene. Med tilfeldige permutasjoner
    // av tall fra f.eks 1-100 ble resultatet nesten alltid 90+ ombyttinger. Dette viser også at metoden er mye tregere.
    // Vi la til maks-metoden i Program klassen fra pensum, og det tok rundt 270 millisek å utføre den.
    // De tre andre maks-metodene vi har sett på i pensum tok fra 85-40 millisek. Så denne metoden er definitivt betydelig tregere.

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

    //Oppgave 7a - Fletting
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

    //Oppgave 7b - Fletting
    public static String flettArray(String... s) {
        int longest = 0;
        for (String str : s){
            if (str.length() > longest){
                longest = str.length();
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i=0; i < longest; i++){
            for (String str: s){
                try {
                    out.append(str.charAt(i));
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return out.toString();
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
    public static int[] tredjeMin(int[] a){
        if (a.length < 3) throw new NoSuchElementException("Tabellet har mindre enn 3 verdier");

        int forstMin = a[0];
        int andreMin = a[1];
        int tredjeMin = a[2];

       if (forstMin > andreMin){
           int temp = andreMin; andreMin = forstMin; forstMin = temp;
       }
       if (andreMin > tredjeMin){
           if (forstMin > tredjeMin){
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

        for (int i = 3; i< a.length; i++){
            int tempLoop = a[i];
            if (tempLoop < tredjeMin){
                if (tempLoop < andreMin){
                    tredjeMin = andreMin;
                    if(tempLoop < forstMin){
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

        return new int[] {forstMin, andreMin, tredjeMin};
    }


    //Oppgave 10 - Inneholdt
    public static boolean inneholdt(String a, String b) {
        boolean inneholdt = false;
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();

        for(int i = 0; i < b.length(); i++){
                if(bMap.containsKey(b.charAt(i))){
                    int count = bMap.get(b.charAt(i));
                    bMap.put(b.charAt(i), count +1);
                } else {
                    bMap.put(b.charAt(i), 1);
                }
        }

        for(int i = 0; i < a.length(); i++){
            if(bMap.containsKey(a.charAt(i))) {
                if (aMap.containsKey(a.charAt(i))) {
                    int count = aMap.get(a.charAt(i));
                    aMap.put(a.charAt(i), count + 1);
                } else {
                    aMap.put(a.charAt(i), 1);
                }
            } else {
                System.out.print(inneholdt);
                return inneholdt;
            }
        }

        for(int i = 0; i < a.length(); i++){
            int countA = aMap.get(a.charAt(i));
            int countB = bMap.get(a.charAt(i));

            if(countA <= countB){
                inneholdt = true;
            } else {
                System.out.print("false");
                return false;
            }
        }
        System.out.print(inneholdt);
        return inneholdt;

        /*
            Set<Character> aSet = new HashSet<>();
        Set<Character> bSet = new HashSet<>();
        StringBuilder aSet2 = new StringBuilder();
        StringBuilder bSet2 = new StringBuilder();

        for(int i = 0; i <a.length(); i++) {
            aSet.add(a.charAt(i));
        }
        for(int i = 0; i < b.length(); i++) {
            bSet.add(b.charAt(i));
        }

        for(int i = 0; i < b.length(); i++) {
            if(aSet.contains(b.charAt(i))) {
                aSet2.append(b.charAt(i));
            }
        }
        for(int i = 0; i < a.length(); i++) {
            if(bSet.contains(a.charAt(i))) {
                bSet2.append(a.charAt(i));
            }
        }

        System.out.println(bSet2 + " " + aSet2);
        if(!bSet.containsAll(aSet) || aSet2.length() < bSet2.length()) {
            System.out.print("false");
            return false;
        } else {
            System.out.print("true");
            return true;
        }

         */
    }
}