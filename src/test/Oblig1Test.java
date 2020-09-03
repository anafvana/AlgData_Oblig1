import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {
    int[] a = {};
    int[][] aa = {
            {1,2,3,4}, {1,2,4,3}, {1,3,2,4}, {1,3,4,2}, {1,4,2,3}, {1,4,3,2},
            {2,1,3,4}, {2,1,4,3}, {2,3,1,4}, {2,3,4,1}, {2,4,1,3}, {2,3,4,1},
            {3,1,2,4}, {3,1,4,2}, {3,2,1,4}, {3,2,4,1}, {3,4,1,2}, {3,4,2,1},
            {4,1,2,3}, {4,1,3,2}, {4,2,1,3}, {4,2,3,1}, {4,3,1,2}, {4,3,2,1}
    };
    int[] b = {22, 49, 5, 115, -2};
    int[] b1 = {115, 22, 49, 5, -2};
    int[] b2 = {22, 49, 5, -2, 115};
    int[] b3 = {115, 49, 5, -2, 22};
    int[] b4 = {-2, 5, 22, 49, 115};
    int[] c = {1};
    int[] d = {3,3,4,5,5,6,7,7,7,8};
    int[] e = {5,3,7,4,3,5,7,8,6,7};
    char[] ch = {'A','B','C','D','E','F','G','H','I','J'};
    char[] ch0 = {};
    char[] ch1 = {'A'};


    @Test
    void maks() {
        //System.out.println("OPPGAVE 1 - MAKS");
        assertThrows(NoSuchElementException.class, () -> Oblig1.maks(a));
        //Fjerner de som har exceptions, siden de kaster dem
        for (int[] ints : aa) {
            assertEquals(4, Oblig1.maks(ints));
            //System.out.println("Array: " + Arrays.toString(ints) + "\nExpected: 4" + "\nResult:" + Oblig1.maks(ints) + "\n");
        }
        //System.out.println("Array: " + Arrays.toString(a) + "\nExpected: 115" + "\nResult:" + Oblig1.maks(b)+ "\n");
        //System.out.println("Array: " + Arrays.toString(b1) + "\nExpected: 115" + "\nResult:" + Oblig1.maks(b1)+ "\n");
        //System.out.println("Array: " + Arrays.toString(b2) + "\nExpected: 115" + "\nResult:" + Oblig1.maks(b2)+ "\n");
        //System.out.println("Array: " + Arrays.toString(c) + "\nExpected: 1" + "\nResult:" + Oblig1.maks(c)+ "\n");
        assertEquals(115, Oblig1.maks(b));
        assertEquals(115, Oblig1.maks(b1));
        assertEquals(115, Oblig1.maks(b2));
        assertEquals(1, Oblig1.maks(c));
    }

    @Test
    void ombyttinger() {
        //System.out.println("OPPGAVE 1 - OMBYTTINGER");
        assertThrows(NoSuchElementException.class, () -> Oblig1.ombyttinger(a));

        int[] aaResults = {
                0, 1, 1, 1, 2, 2,
                1, 2, 1, 1, 2, 1,
                2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3
        };
        for (int i = 0; i < aa.length; i++){
            assertEquals(aaResults[i], Oblig1.ombyttinger(aa[i]));
            //System.out.println("Array: " + Arrays.toString(aa[i]) + "\nExpected: " + aaResults[i] + "\nResult: " + Oblig1.ombyttinger(aa[i]) + "\n");
        }
        //System.out.println("Array: " + Arrays.toString(b) + "\nExpected: 2" + "\nResult: " + Oblig1.ombyttinger((b)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b1) + "\nExpected: 4" + "\nResult: " + Oblig1.ombyttinger((b1)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b2) + "\nExpected: 2" + "\nResult: " + Oblig1.ombyttinger((b2)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b3) + "\nExpected: 4" + "\nResult: " + Oblig1.ombyttinger((b3)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b4) + "\nExpected: 0" + "\nResult: " + Oblig1.ombyttinger((b4)) + "\n");
        //System.out.println("Array: " + Arrays.toString(c) + "\nExpected: 0" + "\nResult: " + Oblig1.ombyttinger((c)) + "\n");

        assertEquals(2, Oblig1.ombyttinger(b));
        assertEquals(4, Oblig1.ombyttinger(b1));
        assertEquals(2, Oblig1.ombyttinger(b2));
        assertEquals(4, Oblig1.ombyttinger(b3));
        assertEquals(0, Oblig1.ombyttinger(b4));
        assertEquals(0, Oblig1.ombyttinger(c));
    }

    @Test
    void antallUlikeSortert() {
        //System.out.println("OPPGAVE 2 - ANTALL ULIKE (SORTERT)");
        //System.out.println("Array: " + Arrays.toString(a) + "\nExpected: 0" + "\nResult: " + Oblig1.antallUlikeSortert(a) + "\n");
        //System.out.println("Array: " + Arrays.toString(b4) + "\nExpected: 5" + "\nResult: " + Oblig1.antallUlikeSortert(b4) + "\n");
        //System.out.println("Array: " + Arrays.toString(c) + "\nExpected: 1" + "\nResult: " + Oblig1.antallUlikeSortert(c) + "\n");
        //System.out.println("Array: " + Arrays.toString(d) + "\nExpected: 6" + "\nResult: " + Oblig1.antallUlikeSortert(d) + "\n");

        assertThrows(IllegalStateException.class, ()-> Oblig1.antallUlikeSortert(b));
        assertEquals(0, Oblig1.antallUlikeSortert(a));
        assertEquals(5, Oblig1.antallUlikeSortert(b4));
        assertEquals(1, Oblig1.antallUlikeSortert(c));
        assertEquals(6, Oblig1.antallUlikeSortert(d));
    }

    @Test
    void antallUlikeUsortert() {
        //System.out.println("OPPGAVE 3 - ANTALL ULIKE (USORTERT)");
        assertEquals(0, Oblig1.antallUlikeUsortert(a));
        //System.out.println("Array: " + Arrays.toString(a) + "\nExpected: 0" + "\nResult: " +  Oblig1.antallUlikeUsortert((a)) + "\n");

        for (int[] ints : aa){
            //System.out.println("Array: " + Arrays.toString(ints) + "\nExpected: 4" + "\nResult: " + Oblig1.antallUlikeUsortert((ints)) + "\n");
            assertEquals(4, Oblig1.antallUlikeUsortert(ints));
        }

        //System.out.println("Array: " + Arrays.toString(b)  + "\nExpected: 5" + "\nResult: " +  Oblig1.antallUlikeUsortert((b)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b1) + "\nExpected: 5" + "\nResult: " + Oblig1.antallUlikeUsortert((b1)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b2) + "\nExpected: 5" + "\nResult: " + Oblig1.antallUlikeUsortert((b2)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b3) + "\nExpected: 5" + "\nResult: " + Oblig1.antallUlikeUsortert((b3)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b4) + "\nExpected: 5" + "\nResult: " + Oblig1.antallUlikeUsortert((b4)) + "\n");
        //System.out.println("Array: " + Arrays.toString(c)  + "\nExpected: 1" + "\nResult: " +  Oblig1.antallUlikeUsortert((c)) + "\n");
        //System.out.println("Array: " + Arrays.toString(d)  + "\nExpected: 6" + "\nResult: " +  Oblig1.antallUlikeUsortert((d)) + "\n");
        //System.out.println("Array: " + Arrays.toString(e)  + "\nExpected: 6" + "\nResult: " +  Oblig1.antallUlikeUsortert((e)) + "\n");

        assertEquals(5, Oblig1.antallUlikeUsortert(b));
        assertEquals(5, Oblig1.antallUlikeUsortert(b1));
        assertEquals(5, Oblig1.antallUlikeUsortert(b2));
        assertEquals(5, Oblig1.antallUlikeUsortert(b3));
        assertEquals(5, Oblig1.antallUlikeUsortert(b4));
        assertEquals(1, Oblig1.antallUlikeUsortert(c));
        assertEquals(6, Oblig1.antallUlikeUsortert(d));
        assertEquals(6, Oblig1.antallUlikeUsortert(e));
    }

    @Test
    void delsortring(){
        //System.out.println("OPPGAVE 4 - DELSORTERING");
        //System.out.println(Arrays.toString(b));
        Oblig1.delsortering(b);
        //System.out.println(Arrays.toString(b) + "\n");
        assertEquals(Arrays.toString(new int[] {5, 49, 115, -2, 22}), Arrays.toString(b));

        //System.out.println(Arrays.toString(d));
        Oblig1.delsortering(d);
        //System.out.println(Arrays.toString(d) + "\n");
        assertEquals(Arrays.toString(new int[] {3, 3, 5, 5, 7, 7, 7, 4, 6, 8}), Arrays.toString(d));

        for (int[] ints : aa){
            //System.out.println(Arrays.toString(ints));
            Oblig1.delsortering(ints);
            //System.out.println(Arrays.toString(ints) + "\n");
            assertEquals(Arrays.toString(new int[] {1, 3, 2, 4}), Arrays.toString(ints));
        }

        //System.out.println(Arrays.toString(a));
        Oblig1.delsortering(a);
        //System.out.println(Arrays.toString(a) + "\n");
        assertEquals(Arrays.toString(new int[] {}), Arrays.toString(a));

        //System.out.println(Arrays.toString(c));
        Oblig1.delsortering(c);
        //System.out.println(Arrays.toString(c) + "\n");
        assertEquals(Arrays.toString(new int[] {1}), Arrays.toString(c));

        int[] eks = {2, 3};
        //System.out.println(Arrays.toString(eks));
        Oblig1.delsortering(eks);
        //System.out.println(Arrays.toString(eks) + "\n");
        assertEquals(Arrays.toString(new int[] {3,2}), Arrays.toString(eks));

        int[] eks2 = {5, 1, 5, 3};
        //System.out.println(Arrays.toString(eks2));
        Oblig1.delsortering(eks2);
        //System.out.println(Arrays.toString(eks2) + "\n");
        assertEquals(Arrays.toString(new int[] {1, 3, 5, 5}), Arrays.toString(eks2));

        int[] eks3 = {2, 6, 4, 2};
        //System.out.println(Arrays.toString(eks3));
        Oblig1.delsortering(eks3);
        //System.out.println(Arrays.toString(eks3) + "\n");
        assertEquals(Arrays.toString(new int[] {2, 2, 4, 6}), Arrays.toString(eks3));
    }

    @Test
    void rotasjon() {
        //System.out.println("OPPGAVE 5 - ROTASJON");
        System.out.println(Arrays.toString(ch));
        Oblig1.rotasjon(ch);
        System.out.println(Arrays.toString(ch) + "\n");

        System.out.println(Arrays.toString(ch0));
        Oblig1.rotasjon(ch0);
        System.out.println(Arrays.toString(ch0) + "\n");

        System.out.println(Arrays.toString(ch1));
        Oblig1.rotasjon(ch1);
        System.out.println(Arrays.toString(ch1) + "\n");
    }

    @Test
    void rotasjonFlerePlasser() {
        //System.out.println("OPPGAVE 6 - ROTASJON (FLERE PLASSER)");
        System.out.println((Arrays.toString(ch)));
        Oblig1.rotasjonFlerePlasser(ch, -2);

        System.out.println((Arrays.toString(ch)));
        Oblig1.rotasjonFlerePlasser(ch, 4);

        System.out.println((Arrays.toString(ch)));
        Oblig1.rotasjonFlerePlasser(ch, 3);

        System.out.println((Arrays.toString(ch)));
        Oblig1.rotasjonFlerePlasser(ch, 1);
        System.out.println((Arrays.toString(ch)));
    }

    @Test
    void flett() {
        //System.out.println("OPPGAVE 7A - FLETTING");
        //System.out.println("Arrays: \"ABC\", \"DEFGH\" \nExpected: ADBECFGH \nResult: " + Oblig1.flett("ABC", "DEFGH") + "\n");
        //System.out.println("Arrays: \"IJKLMN\", \"OPQ\" \nExpected: IOJPKQLMN \nResult: " + Oblig1.flett("IJKLMN", "OPQ") + "\n");
        //System.out.println("Arrays: \"\", \"AB\" \nExpected: AB \nResult: " + Oblig1.flett("", "AB") + "\n");

        assertEquals("ADBECFGH", Oblig1.flett("ABC", "DEFGH"));
        assertEquals("IOJPKQLMN", Oblig1.flett("IJKLMN", "OPQ"));
        assertEquals("AB", Oblig1.flett("", "AB"));
    }

    @Test
    void flettArray() {
        //System.out.println("OPPGAVE 7B - FLETT ARRAY");
        //System.out.println("Arrays: \"AM \", \"L\", \"GEDS\", \"ORATKRR\", \"\", \"R TRTE\", \"IO\", \"TGAUU\" \nExpected: ALGORITMER OG DATASTRUKTURER \nResult: " + Oblig1.flettArray("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU") + "\n");
        //System.out.println("Arrays: \"\", \"\", \"\", \"\" \nExpected:  \nResult: " + Oblig1.flettArray("", "", "", "") + "\n");
        //System.out.println("Arrays: \"\", \"AB\", \"C\", \"DEF\", \" \", \"\" \nExpected: ACD BEF \nResult: " + Oblig1.flettArray("", "AB", "C", "DEF", " ", "") + "\n");

        assertEquals("ALGORITMER OG DATASTRUKTURER", Oblig1.flettArray("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"));
        assertEquals("", Oblig1.flettArray("", "", "", ""));
        assertEquals("ACD BEF", Oblig1.flettArray("", "AB", "C", "DEF", " ", ""));
    }

    @Test
    void indekssortering() {
        //System.out.println("OPPGAVE 8 - INDEKSSORTERING");
        int[] a = {6,10,16,11,7,12,3,9,8,5};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(Oblig1.indekssortering(a)));
        assertEquals(Arrays.toString(new int[] {6, 9, 0, 4, 8, 7, 1, 3, 5, 2}), Arrays.toString(Oblig1.indekssortering(a)));
        int [] indeks = Oblig1.indekssortering(a);
        for(int i = 0; i <a.length; i++){
            System.out.print(a[indeks[i]] + " ");
        }
    }

    @Test
    void tredjeMin() {
        //System.out.println("OPPGAVE 9 - TREDJE MINSTE");
        //System.out.println("Array: " + Arrays.toString(a) + "\nExpected: java.util.NoSuchElementException: Tabellen har mindre enn 3 verdier" + "\nResult:");
        //Oblig1.tredjeMin(a);
        //System.out.println("Array: " + Arrays.toString(c) + "\nExpected: java.util.NoSuchElementException: Tabellen har mindre enn 3 verdier" + "\nResult: ");
        //Oblig1.tredjeMin(c);

        assertThrows(NoSuchElementException.class, () -> Oblig1.tredjeMin(a));
        assertThrows(NoSuchElementException.class, () -> Oblig1.tredjeMin(c));
        for (int[] ints : aa) {
            //System.out.println("Array: " + Arrays.toString(ints) + "\nExpected: " + Arrays.toString(new int[]{1, 2, 3}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(ints)) + "\n");
            assertEquals(Arrays.toString(new int[]{1, 2, 3}), Arrays.toString(Oblig1.tredjeMin(ints)));
        }

        //System.out.println("Array: " + Arrays.toString(b) + "\nExpected: " + Arrays.toString(new int[]{-2, 5, 22}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(b)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b1) + "\nExpected: " + Arrays.toString(new int[]{-2, 5, 22}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(b1)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b2) + "\nExpected: " + Arrays.toString(new int[]{-2, 5, 22}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(b2)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b3) + "\nExpected: " + Arrays.toString(new int[]{-2, 5, 22}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(b3)) + "\n");
        //System.out.println("Array: " + Arrays.toString(b4) + "\nExpected: " + Arrays.toString(new int[]{-2, 5, 22}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(b4)) + "\n");
        //System.out.println("Array: " + Arrays.toString(d) + "\nExpected: " + Arrays.toString(new int[]{3, 3, 4}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(d)) + "\n");
        //System.out.println("Array: " + Arrays.toString(e) + "\nExpected: " + Arrays.toString(new int[]{3, 3, 4}) + "\nResult:" + Arrays.toString(Oblig1.tredjeMin(e)) + "\n");

        assertEquals(Arrays.toString(new int[]{-2, 5, 22}), Arrays.toString(Oblig1.tredjeMin(b)));
        assertEquals(Arrays.toString(new int[]{-2, 5, 22}), Arrays.toString(Oblig1.tredjeMin(b1)));
        assertEquals(Arrays.toString(new int[]{-2, 5, 22}), Arrays.toString(Oblig1.tredjeMin(b2)));
        assertEquals(Arrays.toString(new int[]{-2, 5, 22}), Arrays.toString(Oblig1.tredjeMin(b3)));
        assertEquals(Arrays.toString(new int[]{-2, 5, 22}), Arrays.toString(Oblig1.tredjeMin(b4)));
        assertEquals(Arrays.toString(new int[]{3, 3, 4}), Arrays.toString(Oblig1.tredjeMin(d)));
        assertEquals(Arrays.toString(new int[]{3, 3, 4}), Arrays.toString(Oblig1.tredjeMin(e)));

    }

    @Test
    void inneholdt(){
        //System.out.println("OPPGAVE 10 - INNEHOLDT");
        //System.out.println("ABBABBA" + " inneholder " + "ABBA" + " = " + Oblig1.inneholdt("ABBA", "ABBABBA"));
        //System.out.println("ABBABBA" + " inneholder " + "ABBAB" +  " = " +Oblig1.inneholdt("ABBAB", "ABBABBA"));
        //System.out.println("ABBABBA" + " inneholder " + "ABBAA" +  " = " +Oblig1.inneholdt("ABBAA", "ABBABBA"));
        //System.out.println("ABBABBA" + " inneholder " + "ABBAAA" +  " = " +Oblig1.inneholdt("ABBAAA", "ABBABBA"));
        //System.out.println("ABBABBA" + " inneholder " + "ABBdA" +  " = " +Oblig1.inneholdt("ABBdA", "ABBABBA"));
        //System.out.println("ABDEFSEFDSEBABBA" + " inneholder " + "ABBA" +  " = " +Oblig1.inneholdt("ABBA", "ABDEFSEFDSEBABBA"));
        //System.out.println("ABDEFSEFDSEBABBA" + " inneholder " + "ABBAZ" + " = " + Oblig1.inneholdt("ABBAZ", "ABDEFSEFDSEBABBA"));

        assertTrue(Oblig1.inneholdt("ABBA", "ABBABBA"));
        assertTrue(Oblig1.inneholdt("ABBAB", "ABBABBA"));
        assertTrue(Oblig1.inneholdt("ABBAA", "ABBABBA"));
        assertFalse(Oblig1.inneholdt("ABBAAA", "ABBABBA"));
        assertFalse(Oblig1.inneholdt("ABBdA", "ABBABBA"));
        assertTrue(Oblig1.inneholdt("ABBA", "ABDEFSEFDSEBABBA"));
        assertFalse(Oblig1.inneholdt("ABBAZ", "ABDEFSEFDSEBABBA"));
    }
}