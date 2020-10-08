package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Objects;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    public static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige;
        public Node<T> neste;    // pekere

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
    public Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        /*
        hode = new Node(null);
        hale = new Node(null);
       */
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;

    }

    public DobbeltLenketListe(T[] a) {
        int i = 0;
        //Ser etter den først ikke-null verdi
        while (i < a.length && a[i] == null) { i++; }
        Node<T> p;

        if(i < a.length) {
            //Lager først node og hode
            p = new Node<>(a[i]);
            hode = new Node<>(null, null, p);
            antall = 1;

            //lager andre noder
            for(i++; i < a.length; i++) {
                if(a[i] != null) {
                    p = p.neste = new Node<>(a[i], p, null);
                    antall++;
                }
            }
            hale = new Node<>(null, p, null);
        }
    }

    public Liste<T> subliste(int fra, int til){
        fratilKontroll(fra, til);
        DobbeltLenketListe<T> nyListe = new DobbeltLenketListe<>();
        if (fra != til) {
            Node<T> node = finnNode(fra);

            nyListe.leggInn(node.verdi);

            for (int i = fra + 1; i < til; i++) {
                node = finnNode(i);
                nyListe.leggInn(node.verdi);
            }
        }
        return nyListe;
    }

    public void fratilKontroll(int fra, int til){
        //eksemplet kommer fra pensum
        if (fra < 0){
            // fra er negativ
            throw new IndexOutOfBoundsException ("fra(" + fra + ") er negativ!");
        }
        if (til > antall) {
            // til er utenfor tabellen
            throw new IndexOutOfBoundsException ("til(" + til + ") > antall (" + antall + ")");
        }
        if (fra > til) {
            // fra er større enn til
            throw new IllegalArgumentException ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }

    private Node<T> finnNode(int indeks) {
        int hjelpevariabel;
        Node<T> node;
        if(indeks < antall/2) { // fra hode
            hjelpevariabel = 0;
            node = hode.neste;
            while (indeks != hjelpevariabel){
                hjelpevariabel ++;
                node = node.neste;
            }
        } else { // fra hale
            hjelpevariabel = antall-1;
            node = hale.forrige;
            while (indeks != hjelpevariabel) {
                hjelpevariabel--;
                node = node.forrige;
            }
        }

        return node;
    }

    @Override
    public int antall() {
        return antall;
    }


    @Override
    public boolean tom() {
        //TODO Handle null liste?
        return antall() == 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null verdier!");
        Node<T> p;

        if(antall == 0) {
            p = new Node<>(verdi);
            hode = new Node<>(null, null, p);
            hale = new Node<>(null, p, null);
        } else {
            Node<T> q = hale.forrige;
            p = new Node<>(verdi, q, null);
            q.neste = p;
            hale.forrige = p;
        }
        antall++;
        endringer++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null verdier!");

        indeksKontroll(indeks, true);
        Node<T> p;

        if(indeks == 0) {
            if(antall == 0) {
                p = new Node<>(verdi);
                hode = new Node<>(null, null, p);
                hale = new Node<>(null, p, null);
            } else {
                Node<T> q = hode.neste;
                p = new Node<>(verdi, null, q);
                q.forrige = p;
                hode.neste = p;
            }
        } else if(indeks == antall) {
            Node<T> r = hale.forrige;
            p = new Node<>(verdi, r, null);
            r.neste = p;
            hale.forrige = p;
        } else {
            Node<T> q = hode.neste;
            for(int i = 1; i < indeks; i++) {
                q = q.neste;
            }
            Node<T> s = q.neste;
            p = new Node<>(verdi, q, s);
            s.forrige = p;
            q.neste = p;
        }
        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        //Ignorerer testen om listen er tom eller verdien er null
        if (antall > 0 && verdi!=null) {
            Node<T> p = hode.neste;
            while (p != null) {
                //fant verdien
                if (verdi.equals(p.verdi)) {
                    return true;
                }
                //else... prøv å finne den på neste
                p = p.neste;
            }
        }
        //ikke fant
        return false;
    }

    @Override
    public T hent(int indeks) {
        T verdi = null;
        try {
            verdi = finnNode(indeks).verdi;
            // kun feilmelding dersom det ikke funker pga indeksKontroll tar lang tid.
        } catch (Exception e){
            indeksKontroll(indeks, false);
        }
        return verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        //"hjelpevariabel" som skal faktisk returneres
        int index = 0;

        //Ignorerer sjekk om listen er tom eller verdien er tom
        if (antall > 0 && verdi!=null) {
            //lager node som brukes for testing
            Node<T> p = hode.neste;
            while (p != null) {
                if (verdi.equals(p.verdi)) {
                    return index;
                }
                //prøv igjen med neste node
                p = p.neste;
                index++;
            }
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        if(indeks >= antall || indeks < 0){
            throw new IndexOutOfBoundsException();
        }

        T oldVerdi;
        if(nyverdi == null) {
            throw new NullPointerException();
        } else {
            Node<T> node = finnNode(indeks);
            oldVerdi = node.verdi;
            node.verdi = nyverdi;
            endringer++;
        }
        return oldVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if(verdi == null){
            return false;
        }


        Node<T> node = hode.neste;
        while(!node.verdi.equals(verdi)){
            if(node.neste == null){
                return false;
            }
            node = node.neste;
        }

        if (node.equals(hode.neste) && node.equals(hale.forrige)) {
            hode.neste = null;
            hale.forrige = null;
        } else if(node.equals(hode.neste)){
            hode.neste.neste.forrige = null;
            hode.neste = hode.neste.neste;
            node.neste = null;
        } else if(node.equals(hale.forrige)){
            hale.forrige = node.forrige;
            node.forrige.neste = null;
            node.forrige = null;
        } else {
            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
        }

        antall--;
        endringer++;
        return true;
    }

    @Override
    public T fjern(int indeks) {
        if (indeks < 0 || (indeks > antall-1)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = finnNode(indeks);
        try{
            if(indeks == 0){
                if(hode.neste.neste != null) {
                    hode.neste.neste.forrige = null;
                    hode.neste = hode.neste.neste;
                    node.neste = null;
                } else {
                    node.neste = null;
                    node.forrige = null;
                    hode.neste = null;
                    hale.forrige = null;
                }
            } else if(indeks == antall-1){
                hale.forrige = node.forrige;
                node.forrige.neste = null;
                node.forrige = null;
            } else {
                node.forrige.neste = node.neste;
                node.neste.forrige = node.forrige;
                node.forrige = null;
                node.neste = null;
            }
            antall--;
            endringer++;

        } catch (Exception e){
            indeksKontroll(indeks, false);
        }
        return node.verdi;
    }

    @Override
    public void nullstill() {
        //FØRSTE MÅTE
        if (antall>0) {
            //Hjelpevariabelen for noden vi er på nå
            Node<T> curP = hode.neste;

            //Sletter alle noder unntatt siste
            while (curP.neste != null){
                curP = curP.neste;
                curP.forrige.forrige = null;
                curP.forrige.verdi = null;
                curP.forrige.neste = null;
                antall--;
                endringer++;
            }
            //Sletter siste node
            curP.forrige = null;
            curP.verdi = null;
            curP.neste = null;
            antall--;
            endringer++;
        }

        /*
        //ANDRE MÅTE
        //Hjelpevariabel slik at antall ikke endrer seg
        int toDelete = antall;
        if (antall>0) {
            for (int i=0; i<toDelete; i++){
                fjern(0);
            }
        }*/
    }

    public void nullstill2(){
        //ANDRE MÅTE
        //Hjelpevariabel slik at antall ikke endrer seg
        int toDelete = antall;
        if (antall>0) {
            for (int i=0; i<toDelete; i++){
                fjern(0);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(!tom()) {
            Node<T> p = hode.neste;
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
            Node<T> p = hale.forrige;
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
            indeksKontroll(indeks, false);
            denne = finnNode(indeks-1);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            if(endringer != iteratorendringer) {
                throw new ConcurrentModificationException();
            }
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T verdi;
            fjernOK = true;
            if(denne.neste.neste == null) {
                verdi = denne.neste.verdi;
                denne = null;
            } else {
                verdi = denne.neste.verdi;
                denne = denne.neste;
            }

            return verdi;
        }

        @Override
        public void remove(){
            if(endringer != iteratorendringer){
                throw new ConcurrentModificationException();
            }
            if(!fjernOK) {
                throw new IllegalStateException("Ulovlig tilstand!");
            }

            fjernOK = false;
            Node<T> p = hode.neste;
            if(hode.neste.equals(denne)) {
                if(antall == 1) {
                    hode.neste = null;
                    hale.forrige = null;
                } else {
                    Node<T> t = p.neste;
                    hode.neste = t;
                    t.forrige = null;
                }
            } else if(antall == 1) {
                hode.neste = null;
                hale.neste = null;
            } else {
                while (p.neste != denne) {
                    p = p.neste;
                }
                if(denne == null) {
                    hale.forrige = p.forrige;
                    p.forrige.neste = null;
                } else {
                    Node<T> s = denne.neste;
                    p.neste = s;
                    s.forrige = p;
                }
            }

            antall --;
            endringer++;
            iteratorendringer++;
        }
    } // class DobbeltLenketListeIterator


    //Gikk for bubblesort metoden
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        //Hvis det er en tom liste eller en liste med ett element, ikke gjør noe mer
        if(liste.tom() || liste.antall() == 1) {
            return;
        }
        boolean byttet = true;
        int antallFlyttet = 1;  //Starter på 1 for at vi ikke skal få en out of bounds exception
        while (byttet) {
            byttet = false;
            for(int i = 0; i < liste.antall() - antallFlyttet; i++) {
                T p = liste.hent(i);
                T q = liste.hent(i + 1);
                if(c.compare(p, q) > 0) {
                    liste.oppdater(i, q);
                    liste.oppdater(i + 1, p);
                    byttet = true;
                }
            }
            antallFlyttet++;
        }
    }

} // class DobbeltLenketListe


