package b07;

/**
 * Hilfsklasse für {@link b07.LinkedList} zur Repräsentation eines
 * Listenknotens.
 * 
 * Ein Knoten hält eine Referenz auf die Nutzdaten sowie auf den nächsten Knoten
 * in der Liste.
 * 
 * Node muss generisch realisiert werden, d.h. der Typ der Nutzdaten muss
 * generisch sein.
 * 
 * Um die Liste sortieren zu können, muss der Typparameter von Node vergleichbar
 * sein. Weiterhin soll ein Knoten selbst vergleichbar sein, wobei der Vegleich
 * zwischen Knoten intern in Node auf den Vergleich der Nutzdaten zurückgeführt
 * wird.
 * 
 * Vorgabe:
 * @author Anton Oster
 * @author Ronald Lepp
 * @author Matthias Guzy
 * @author Steven Yeates
 * 
 * Vorgabe bearbeitet:
 * @author Oxana Zhurakovskaya
 * 
 * @param <E>
 *           Typparameter für Nutzdaten, muss vergleichbar sein
 */
public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

   private E daten;
   private Node<E> next;

   public Node(E data) {
      this.setDaten(data);
      this.next = null;
   }

   /**
    * liefert die enthaltene Nutzdaten zurück.
    * 
    * @return Nutzdaten
    */
   public E getDaten() {
      return this.daten;
   }

   /**
    * setzt als Argument vorgegebenen Nutzdaten.
    * 
    * @param daten
    *           - Nutzdaten
    */
   public void setDaten(E daten) {
      this.daten = daten;
   }

   /**
    * liefert Referenz zu nächsten Node.
    * 
    * @return next - Nächste Node
    */
   public Node<E> getNext() {
      return this.next;
   }

   /**
    * setzt als Argument vorgegebene Node als nächste Node
    * 
    * @param next
    */
   public void setNext(Node<E> next) {
      this.next = next;
   }

   /**
    * Vergleicht diese Node mit der in Argument vorgegebenen.
    * 
    * Vegleich zwischen Knoten führt auf den Vergleich der Nutzdaten zurück
    * 
    * @return ergebniss des Vergleichs von zwei Nutzdaten
    * @see int java.lang.Comparable.compareTo(T o)
    */
   @Override
   public int compareTo(Node<E> n) {
      return this.getDaten().compareTo(n.getDaten());
   }

   @Override
   public String toString() {
      return "Node [daten=" + daten + ", next=" + next + "]";
   }
   
   @Override
   public boolean equals(Object obj) {
     if (obj == this) {
         return true;
     }
     if (obj == null || obj.getClass() != this.getClass()) {
         return false;
     }

     Node<E> n = (Node<E>) obj;
     return (this.getDaten()== n.getDaten() );
 }
}
