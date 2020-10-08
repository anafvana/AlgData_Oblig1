package no.oslomet.cs.algdat;

import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Character[] c = {'A', 'B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.antall());
        System.out.println(liste.indeksTil('J'));
        System.out.println(liste.tom());
        System.out.println(liste.subliste(3,8)); // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5)); // []
        System.out.println(liste.subliste(8,liste.antall())); // [I, J]

        Character[] d = {};
        DobbeltLenketListe<Character> liste2 = new DobbeltLenketListe<>(d);
        System.out.println(liste2.antall());
        Liste<Integer> intList = new DobbeltLenketListe<>();
        for(int i = 2; i < 1000; i++) {
            intList.leggInn(i - 2);
            intList.leggInn(i + 2);
        }
        System.out.println(intList);
        DobbeltLenketListe.sorter(intList, Comparator.naturalOrder());
        System.out.println(intList);

        Liste<String> strListe = new DobbeltLenketListe<>();
        strListe.leggInn("Stein");
        strListe.leggInn("Alf");
        strListe.leggInn("Kjell");
        strListe.leggInn("Preben");
        strListe.leggInn("Bjarne");
        strListe.leggInn("Kalle");
        System.out.println(strListe);
        DobbeltLenketListe.sorter(strListe, Comparator.naturalOrder());
        System.out.println(strListe);
        DobbeltLenketListe<Integer> liste3 = new DobbeltLenketListe<>();
        for(int i = 1; i <= 7; i++) {
            liste3.leggInn(i);
        }
        System.out.println(liste3);
        Iterator<Integer> it = liste3.iterator();

        for(int i = 0; i < liste3.antall(); i++) {
            System.out.print(it.next() + " ");
        }

        DobbeltLenketListe<Integer> liste4 = new DobbeltLenketListe<>();

        for (int k = 1; k <= 13; k++) {
            liste4.leggInn(k);
        }
        System.out.println();
        for (Iterator<Integer> i = liste4.iterator(); i.hasNext(); ) {
            int verdi = i.next();
            if (verdi % 2 == 1) {
                i.remove(); // fjerner oddetallene
                System.out.println(liste4 + " - " + liste4.omvendtString());
            }
        }
        Iterator<Integer> j = liste4.iterator();
        for (; j.hasNext(); ) {
            int verdi = j.next();
            j.remove();
            System.out.println(liste4 + " - " + liste4.omvendtString());
        }


// System.out.println(liste.subliste(0,11)); // skal kaste unntak
   }
}
