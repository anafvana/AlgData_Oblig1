package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        throw new UnsupportedOperationException();
    }

    public DobbeltLenketListe(T[] a) {
        throw new UnsupportedOperationException();
    }

    public Liste<T> subliste(int fra, int til){
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks) {
        indeksKontroll(indeks, false); //sjekk om indeksen er gyldig
        // TO DO: ANTALL() MÅ FJERNES DETTE ER BARE FOR Å TESTE NÅ
        antall();
        int hjelpevariabel = 0; //angir indeksen
        Node<T> node;

        if(indeks < antall/2) //Sjekk om det skal starte fra hode eller hale
        {
            node = hode.neste;
            while (indeks != hjelpevariabel){
                hjelpevariabel ++; // hjelpevariebel øker helt til indeksen er lik hjelpvariabel
                node = node.neste;
            }
        } else { // sjekker fra hale
            node = hale.forrige;
            hjelpevariabel = antall-1; // hjelpevariabel er lik antall elementer -1

            if (indeks == hjelpevariabel){ //sjekk om det er siste element
                return node;
            } else if(indeks > hjelpevariabel){
                //  TO DO MÅ TESTES OM DENNE ER NØDVENDIG
                return null;
            } else {
                while (indeks != hjelpevariabel) { //looper gjennom nodene
                    hjelpevariabel--;
                    node = node.forrige;
                }
            }
        }

        return node;
    }

    @Override
    public int antall() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tom() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Det er ikke tillatt med null-verdier!");

        if(antall == 0) {
            hode = hale = new Node<>(verdi, null, null);
        } else {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        antall++;
        endringer++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Det er ikke tillatt med null-verdier!");

        indeksKontroll(indeks, true);

        if(indeks == 0) {       //hvis den skal legges inn først
            if(antall == 0) {   //hvis det er en tom tabell
                hode = new Node<>(verdi, null, hode);
                hale = hode;
            } else {            //ikke en tom tabell for indeks = 0

            }
        } else if(indeks == antall) { //hvis den skal settes bakerst

        } else {                //hvis den skal settes andre steder i tabellen

        }
        //hvis verdien ikke er null og indeksen går gjennom kontrollen
        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false); // sjekker indeksen
        Node<T> node = finnNode(indeks);
        T oldVerdi = node.verdi; // lagre old verdien
        node.verdi = nyverdi;
        endringer++;
        return oldVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(!tom()) {
            Node<T> p = hode;
            sb.append(p.verdi);
            p = p.neste;

            while (p != null) {
                sb.append(",").append(" ").append(p.verdi);
                p = p.neste;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String omvendtString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(!tom()) {
            Node<T> p = hale;
            sb.append(p.verdi);
            p = p.forrige;

            while (p != null) {
                sb.append(",").append(" ").append(p.verdi);
                p = p.forrige;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            if(iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Listen har blitt endret!");
            }
            if(!hasNext()) {
                throw new NoSuchElementException("Ingen verdier i listen!");
            }

            fjernOK = true;
            T denneVerdi = denne.verdi;
            denne = denne.neste;

            return denneVerdi;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


