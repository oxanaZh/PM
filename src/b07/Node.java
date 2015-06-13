package src.b07;

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
 * 
 * @author Anton Oster
 * @author Ronald Lepp
 * @author Matthias Guzy
 * @author Steven Yeates
 * 
 *         Vorgabe bearbeitet:
 * @author Oxana Zhurakovskaya
 * 
 * @param <E>
 *           Typparameter für Nutzdaten, muss vergleichbar sein
 */
public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

   private E content;
   private Node<E> next;

   public Node(E data) {
      this.setContent(data);
      this.next = null;
   }

   /**
    * liefert die enthaltene Nutzdaten zurück.
    * 
    * @return Nutzdaten
    */
   public E getContent() {
      return this.content;
   }

   /**
    * setzt als Argument vorgegebenen Nutzdaten.
    *
    * @param content
    *           - Nutzdaten
    */
   public void setContent(E content) {
      this.content = content;
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
    * @see {@link java.lang.Comparable}
    */
   @Override
   public int compareTo(Node<E> n) {
      return this.getContent().compareTo(n.getContent());
   }

   @Override
   public String toString() {
      return this.getContent().toString();
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Node)) return false;

      Node<?> node = (Node<?>) o;

      if (content != null ? !content.equals(node.content) : node.content != null) return false;
      return !(next != null ? !next.equals(node.next) : node.next != null);

   }

   @Override
   public int hashCode() {
      int result = content != null ? content.hashCode() : 0;

      return result;
   }
}
