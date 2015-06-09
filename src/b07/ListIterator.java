package b07;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E extends Comparable<E>> implements Iterator<E> {
   private LinkedList<E> list = null;
   private int cursor = 0;

   public ListIterator(LinkedList<E> l) {
      this.list = l;
   }

   /**
    * liefert {@code true} wenn es noch ein Element in der Liste gibt.
    * 
    * es wird angenomen, dass es noch ein Element gibt, wenn in der Liste die
    * Variable size > 0 ist
    * 
    * @return {@code true} wenn ein nächste Element Existiert, sonst
    *         {@code false}
    * @see {@link java.util.Iterator}
    */
   @Override
   public boolean hasNext() {
      return this.cursor < list.size();
   }

   /**
    * liefert den nächsten element in der Liste, wärend der iteration.
    * 
    * @return nächsten Element
    * @throws NoSuchElementException
    *            wenn es keine Element mehr gibt
    * @see {@link java.util.Iterator}
    */
   @Override
   public E next() {
      try {
         return list.get(cursor++);
      } catch (IndexOutOfBoundsException e) {
         throw new NoSuchElementException();
      }
   }

   /**
    * die operation ist verboten
    */
   @Override
   public void remove() {
      throw new UnsupportedOperationException();

   }

}
