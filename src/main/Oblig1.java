import java.util.NoSuchElementException;

public class Oblig1 {
    // Øyvind Ødegård Stenberg - s188886
    // Ana Flávia Vital - s344046
    // Mark van der Baan -

    //Oppgave 1 - finne største tall
    public static int maks(int[] a) {
        sjekkArray(a);
        int forste;
        int neste;
        for(int i = 1; i < a.length; i++) {
            forste = a[i-1];
            neste = a[i];
            if(forste > neste) {
                a[i] = forste;
                a[i-1] = neste;
            }
        }
        return a[a.length-1];
    }

    //Oppgave 1 - Telle antall ombyttinger
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
        System.out.println(antall);
        return antall;
    }

    //VI TRENGER Å SVARE SPØRSMÅL ENDA

    public static void sjekkArray(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Arrayet er tom!");
    }

    //Oppgave 2 - antall ulike (sortert)
    public static int antallUlikeSortert(int[] a) {
        int antall = 0;
        for(int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]) {
                throw new IllegalStateException("Arrayet er ikke sortert i stigende rekkefølge!");
            }
            if(a[i] < a[i+1]) {
                antall++;
            }
        }
        // Legger på en ekstra fordi for-løkken ikke går innom det siste tallet i tabellen.
        if(a.length > 0) {
            antall++;
        }
        return antall;
    }

    //Oppgave 3 - antall ulike (usortert)
    public static int antallUlikeUsortert(int[] a){
        //check against all the previous ones
        int antall = 0;
        for (int i=0; i<a.length; i++){
            boolean matches = false;
            for (int j=0; j<i; j++){
                if (a[i] == a[j]) {
                    matches = true;
                    break;
                }
            }
            if (!matches) antall++;
        }
        return antall;
    }

}