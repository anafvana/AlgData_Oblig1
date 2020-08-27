public class Oblig1 {
    // Øyvind Ødegård Stenberg - s188886
    // Ana Flávia Vital - s344046
    // Mark van der Baan -

    //Oppgave 1 - finne største tall
    public static int maks(int[] a) {
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

    // Telle antall ombyttinger
    public static int ombyttinger(int[] a) {
        int forste;
        int neste;
        int antall = 0;
        for(int i = 1; i < a.length; i++) {
            forste = a[i-1];
            neste = a[i];
            if(forste > neste) {
                antall++;
                a[i] = forste;
                a[i-1] = neste;
            }
        }
        return antall;
    }
}
