package no.oslomet.cs.algdat;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
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
        DobbeltLenketListe.bubbleSort(intList, Comparator.naturalOrder());
        System.out.println(intList);

        Liste<String> strListe = new DobbeltLenketListe<>();
        strListe.leggInn("Stein");
        strListe.leggInn("Alf");
        strListe.leggInn("Kjell");
        strListe.leggInn("Preben");
        strListe.leggInn("Bjarne");
        strListe.leggInn("Kalle");
        System.out.println(strListe);
        DobbeltLenketListe.bubbleSort(strListe, Comparator.naturalOrder());
        System.out.println(strListe);


// System.out.println(liste.subliste(0,11)); // skal kaste unntak
   }
}
