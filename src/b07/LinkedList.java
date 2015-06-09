package b07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Klasse für eine einfach verkettete Liste (vgl. LV "ADS").
 * 
 * Die Liste hält eine Referenz auf den ersten Knoten der Liste und speichert
 * aus Effizienzgründen die aktuelle Länge der Liste.
 * 
 * LinkedList muss generisch realisiert werden, d.h. der Typ der Nutzdaten muss
 * generisch sein.
 * 
 * Nach aussen soll die interne Repräsentation nicht sichtbar sein, d.h. es darf
 * in den Schnittstellen und Deklarationen keinen Hinweis auf den Hilfstypen
 * {@link b07.Node} geben.
 * 
 * Eine Liste muss iterierbar sein.
 * 
 * Implementieren Sie mindestens die vorgegebenen Methoden entsprechend den
 * Hinweisen auf Blatt 07 und den JavaDoc-Kommentaren an den Methoden.
 * 
 * Vorgabe:
 * 
 * @author Anton Oster
 * @author Ronald Lepp
 * @author Matthias Guzy
 * 
 *         Vorgabe bearbeitet:
 * @author Oxana Zhurakovskaya
 * 
 * @param <T>
 *           Typparameter für Nutzdaten, muss vergleichbar sein
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

   private Node<T> head;
   private int size;

   public LinkedList() {
      this.head = null;
      this.size = 0;
   }

   /**
    * Inserts the specified element at the specified position in this list.
    * Shifts the element currently at that position (if any) and any subsequent
    * elements to the right (adds one to their indices).
    * 
    * Vorgabe
    * 
    * @param index
    *           index at which the specified element is to be inserted
    * @param toAdd
    *           element to be inserted
    * @throws IndexOutOfBoundsException
    *            if the index is out of range (index < 0 || index > size())
    */
   public void add(int index, T toAdd) { 
      Node<T> parentNode;
      try{
         parentNode = getNodeAtIndex(index);
      }
      catch(IndexOutOfBoundsException e){
         throw e;
      }
      Node<T> newNode =new Node<T>(toAdd);
      //newNode next zeigt auf ursprüngliche next Node von parentNode
      newNode.setNext(parentNode.getNext());
      // parentNode next zeigt nun auf NewNode
      parentNode.setNext(newNode);
//TODO auf nullpointer prüfen
   }

   /**
    * Appends the specified element to the end of this list.
    * 
    * Vorgabe
    * 
    * @param toAdd
    *           the element to be appended to the list.
    */
   public void add(T toAdd) {
      //tut das gleiche wie add(int index, T toAdd) nur der index = size
      this.add(size, toAdd);
   }

   /**
    * Appends all of the elements from a list or collection.
    * 
    * Vorgabe
    * 
    * @param collection
    *           the list from which the elements should be added.
    * @throws NullPointerException
    *            if the specified collection is null
    */
   public void addAll(Iterable<T> collection) {

      // TODO

   }

   /**
    * Removes all of the elements from this list. The list will be empty after
    * this call returns.
    * 
    * Vorgabe
    * 
    */
   public void clear() {
      this.head = null;
      this.size=0;
   }

   /**
    * Returns a true if the list contains the object.
    * 
    * Vorgabe
    * 
    * @param toSearch
    *           the element whose presence in this list is to be tested
    * @return true if object is in list, else false.
    */
   public boolean contains(T toSearch) {

      // TODO
      return false;
   }

   /**
    * Returns the element at the specified position in this list.
    * 
    * Vorgabe
    * 
    * @param index
    *           index of the element to return.
    * @return the element at the specified position in this list.
    * @throws IndexOutOfBoundsException
    *            if the index is out of range (index < 0 || index >= size())
    * @throws NoSuchElementException
    *            if list is empty
    */
   public T get(int index) {
      if(isEmpty()){
         throw new NoSuchElementException();
      }
      
      T found = null;
      try{
         found = this.getNodeAtIndex(index).getDaten();
      }
      catch(IndexOutOfBoundsException e){
         throw e;
      }
      catch (NullPointerException npEx) {
         throw new NoSuchElementException();
      }
      return found;
   }

   /**
    * Returns the first element in the List.
    * 
    * Vorgabe
    * 
    * @return the first element in the List.
    * @throws NoSuchElementException
    *            if this list is empty
    */
   public T getFirst() {
      if(isEmpty()){
         throw new NoSuchElementException();
      }
      return this.head.getDaten();
      // TODO

   }

   /**
    * Returns the last element in this list.
    * 
    * Vorgabe
    * 
    * @return the last element in this list
    * @throws NoSuchElementException
    *            if this list is empty
    */
   public T getLast() {
      return this.get(size);
      // TODO exceptions

   }

   /**
    * Returns the index of the first occurrence of the specified element in this
    * list, or -1 if this list does not contain the element.
    * 
    * Vorgabe
    * 
    * @param toFind
    *           the object to find in list.
    * @return the index of the first occurrence of the object in the list (or
    *         -1).
    */
   public int indexOf(T toFind) {

      // TODO
      return 0;
   }

   /**
    * Returns true if list is empty, else false.
    * 
    * Vorgabe
    * 
    * @return true if list is empty.
    */
   public boolean isEmpty() {

      return this.size >0;

   }

   /**
    * Removes and returns the last element of this list.
    * 
    * Vorgabe
    * 
    * @return the last element.
    * @throws NoSuchElementException
    *            if this list is empty
    */
   public T pop() {

      // TODO
      return null;
   }

   /**
    * Appends element to the end of the list.
    * 
    * Vorgabe
    * 
    * @param toAdd
    *           the element to add.
    */
   public void push(T toAdd) {
      //TODO

   }

   /**
    * Removes the element at the specified position in this list. Shifts any
    * subsequent elements to the left (subtracts one from their indices).
    * Returns the element that was removed from the list.
    * 
    * Vorgabe
    * 
    * @param index
    *           the index of the element to be removed
    * @return the element previously at the specified position
    * @throws IndexOutOfBoundsException
    *            if the index is out of range (index < 0 || index >= size())
    */
   public T remove(int index) {
      T found = null;
      // TODO
      return found;
      

   }

   /**
    * Removes the first occurrence of the specified element from this list, if
    * it is present. If this list does not contain the element, it is unchanged.
    * 
    * Vorgabe
    * 
    * @param toSearch
    *           element to search after in the list.
    * @return the removed the element.
    */
   public T remove(T toSearch) {
      T found = null;
      // TODO
      return found;
   }

   /**
    * Replaces the element at the specified position in this list with the
    * specified element.
    * 
    * Vorgabe
    * 
    * @param index
    *           index of the element to replace
    * @param element
    *           element to be stored at the specified position
    * @throws IndexOutOfBoundsException
    *            if the index is out of range (index < 0 || index >= size())
    */
   public void set(int index, T toSet) {

      // TODO

   }

   /**
    * Returns the number of elements in this list.
    * 
    * Vorgabe
    * 
    * @return the number of elements in this list
    */
   public int size() {

      return this.size;

   }

   /**
    * Sorts this list according to the the elements' natural ordering.
    * 
    * Vorgabe
    */
   public void sort() {

      // TODO

   }

   /**
    * Sorts this list according to the order induced by the specified
    * {@link Comparator}. The comparator needs to be parametrized with the
    * (generic) type of the data stored in the nodes.
    * 
    * Vorgabe
    * 
    * @param c
    *           the {@code Comparator} used to compare list elements.
    */
   public void sort(Comparator c) {

      // TODO

   }

   /**
    * Returns a view of the portion of this list between the specified fromIndex
    * (inclusive), and toIndex (inclusive).
    * 
    * If fromIndex and toIndex are equal, the returned list is empty.
    * 
    * The returned list is backed by this list, so non-structural changes in the
    * returned list are reflected in this list, and vice-versa. The returned
    * list supports all of the optional list operations supported by this list.
    * 
    * Vorgabe
    * 
    * @param fromIndex
    *           low endpoint (inclusive) of the subList
    * @param toIndex
    *           high endpoint (inclusive) of the subList
    * @return a view of the specified range within this list
    * @throws IndexOutOfBoundsException
    *            for an illegal endpoint index value (fromIndex < 0 || toIndex
    *            >= size)
    * @throws IllegalArgumentException
    *            for toIndex < fromIndex
    */
   public LinkedList<T> subList(int fromIndex, int toIndex) {
      LinkedList<T> newList= new LinkedList<T> ();
      // TODO
      return newList;
   }
   /**
    * liefert Node unter bestimmten Index 
    * 
    * private methode, weil man nach außen die Nodes verstecken sollte
    * @param index
    * @return gefundene Node<T>
    * @throws IndexOutOfBoundsException wenn (index < 0 || index > size()) ist
    */
   private Node<T> getNodeAtIndex(int index){
      if(index > this.size() || index < 0){
         throw new IndexOutOfBoundsException();
      }
      Node<T> n = this.head;
      //TODO for(int i = 0; i < index ; i++) muss man noch prüffen ob das  i < index so stimmt
      //TODO NullPointerException abfangen
      for(int i = 0; i < index ; i++){
         n = n.getNext();
      }
      return n;
   }
   
   private Node<T> getLastNode(){
      //TODO
      return getNodeAtIndex(this.size());
   }

   @Override
   public Iterator iterator() {
      //TODO exceptions
      return new ListIterator(this);
   }

}
