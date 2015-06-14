package src.b07;


import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

/**
 * Klasse für eine einfach verkettete Liste (vgl. LV "ADS").
 * <p>
 * Die Liste hält eine Referenz auf den ersten Knoten der Liste und speichert
 * aus Effizienzgründen die aktuelle Länge der Liste.
 * <p>
 * LinkedList muss generisch realisiert werden, d.h. der Typ der Nutzdaten muss
 * generisch sein.
 * <p>
 * Nach aussen soll die interne Repräsentation nicht sichtbar sein, d.h. es darf
 * in den Schnittstellen und Deklarationen keinen Hinweis auf den Hilfstypen
 * {@link b07.Node} geben.
 * <p>
 * Eine Liste muss iterierbar sein.
 * <p>
 * Implementieren Sie mindestens die vorgegebenen Methoden entsprechend den
 * Hinweisen auf Blatt 07 und den JavaDoc-Kommentaren an den Methoden.
 * <p>
 * Vorgabe:
 *
 * @param <T> Typparameter für Nutzdaten, muss vergleichbar sein
 * @author Anton Oster
 * @author Ronald Lepp
 * @author Matthias Guzy
 *         <p>
 *         Vorgabe bearbeitet:
 * @author Oxana Zhurakovskaya
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
     * <p>
     * Vorgabe
     *
     * @param index index at which the specified element is to be inserted
     * @param toAdd element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    public void add(int index, T toAdd) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(toAdd);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> parentNode = getNodeAtIndex(index - 1);

            //newNode next zeigt auf ursprüngliche next Node von parentNode
            newNode.setNext(parentNode.getNext());
            // parentNode next zeigt nun auf NewNode
            parentNode.setNext(newNode);
        }

        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * <p>
     * Vorgabe
     *
     * @param toAdd the element to be appended to the list.
     */
    public void add(T toAdd) {
        //tut das gleiche wie add(int index, T toAdd) nur der index = size
        this.add(size, toAdd);
    }

    /**
     * Appends all of the elements from a list or collection.
     * <p>
     * Vorgabe
     *
     * @param collection the list from which the elements should be added.
     * @throws NullPointerException if the specified collection is null
     */
    public void addAll(Iterable<T> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }

        Node<T> currentParent = null;

        if (size != 0) {
            currentParent = getLastNode();
        }

        for (T t : collection) {
            Node<T> node = new Node<>(t);

            if (currentParent == null) {
                currentParent = node;
                head = node;
            } else {
                currentParent.setNext(node);
                currentParent = node;
            }

            size++;
        }
    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns.
     * <p>
     * Vorgabe
     */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns a true if the list contains the object.
     * <p>
     * Vorgabe
     *
     * @param toSearch the element whose presence in this list is to be tested
     * @return true if object is in list, else false.
     */
    public boolean contains(T toSearch) {
        return indexOf(toSearch) != -1;
    }

    /**
     * Returns the element at the specified position in this list.
     * <p>
     * Vorgabe
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     * @throws NoSuchElementException    if list is empty
     */
    public T get(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return getNodeAtIndex(index).getContent();
        }
    }

    /**
     * Returns the first element in the List.
     * <p>
     * Vorgabe
     *
     * @return the first element in the List.
     * @throws NoSuchElementException if this list is empty
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return get(0);
        }
    }

    /**
     * Returns the last element in this list.
     * <p>
     * Vorgabe
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        {
            return get(size - 1);
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     * <p>
     * Vorgabe
     *
     * @param toFind the object to find in list.
     * @return the index of the first occurrence of the object in the list (or
     * -1).
     */
    public int indexOf(T toFind) {
        if (isEmpty()) {
            return -1;
        } else {
            Node<T> current = head;

            for (int i = 0; i < size; i++) {
                if (current.getContent().equals(toFind)) {
                    return i;
                }

                current = current.getNext();
            }

            return -1; //Element was not found
        }
    }

    /**
     * Returns true if list is empty, else false.
     * <p>
     * Vorgabe
     *
     * @return true if list is empty.
     */
    public boolean isEmpty() {
        return this.size <= 0;
    }

    /**
     * Removes and returns the last element of this list.
     * <p>
     * Vorgabe
     *
     * @return the last element.
     * @throws NoSuchElementException if this list is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return remove(size - 1);
        }
    }

    /**
     * Appends element to the end of the list.
     * <p>
     * Vorgabe
     *
     * @param toAdd the element to add.
     */
    public void push(T toAdd) {
        add(size, toAdd);
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * <p>
     * Vorgabe
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> result;

            if (index == 0) {
                result = head;

                head = head.getNext();
            } else {
                Node<T> parent = getNodeAtIndex(index - 1);

                result = parent.getNext();
                parent.setNext(result.getNext());
            }

            size--;
            return result.getContent();
        }
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present. If this list does not contain the element, it is unchanged.
     * <p>
     * Vorgabe
     *
     * @param toSearch element to search after in the list.
     * @return the removed the element.
     */
    public T remove(T toSearch) {
        if (!isEmpty()) {
            Node<T> current = head;

            for (int i = 0; i < size - 1; i++) {
                if (current.getNext().getContent().equals(toSearch)) {
                    T result = current.getNext().getContent();

                    current.setNext(current.getNext().getNext());
                    size--;
                    return result;
                }

                current = current.getNext();
            }
        }

        return null;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * <p>
     * Vorgabe
     *
     * @param index index of the element to replace
     * @param toSet element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public void set(int index, T toSet) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            getNodeAtIndex(index).setContent(toSet);
        }
    }

    /**
     * Returns the number of elements in this list.
     * <p>
     * Vorgabe
     *
     * @return the number of elements in this list
     */
    public int size() {
        return this.size;
    }

    /**
     * Sorts this list according to the the elements' natural ordering.
     * <p>
     * Vorgabe
     */
    public void sort() {
        //TODO
    }

    /**
     * Sorts this list according to the order induced by the specified
     * {@link Comparator}. The comparator needs to be parametrized with the
     * (generic) type of the data stored in the nodes.
     * <p>
     * Vorgabe
     *
     * @param c the {@code Comparator} used to compare list elements.
     */
    public void sort(Comparator c) {
        //TODO
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex
     * (inclusive), and toIndex (inclusive).
     * <p>
     * If fromIndex and toIndex are equal, the returned list is empty.
     * <p>
     * The returned list is backed by this list, so non-structural changes in the
     * returned list are reflected in this list, and vice-versa. The returned
     * list supports all of the optional list operations supported by this list.
     * <p>
     * Vorgabe
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (inclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value (fromIndex < 0 || toIndex
     *                                   >= size)
     * @throws IllegalArgumentException  for toIndex < fromIndex
     */
    public LinkedList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size) {
            throw new IndexOutOfBoundsException();
        } else if (toIndex < fromIndex) {
            throw new IllegalArgumentException();
        } else {
            LinkedList<T> newList = new LinkedList<T>();
            Node<T> current = getNodeAtIndex(fromIndex);

            for (; fromIndex <= toIndex; fromIndex++) {
                newList.add(current.getContent());

                current = current.getNext();
            }

            return newList;
        }
    }

    /**
     * liefert Node unter bestimmten Index
     * <p>
     * private methode, weil man nach außen die Nodes verstecken sollte
     *
     * @param index
     * @return gefundene Node<T>
     * @throws IndexOutOfBoundsException wenn (index < 0 || index > size()) ist
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            return current;
        }
    }

    private Node<T> getLastNode() {
        return getNodeAtIndex(size - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current;

            @Override
            public boolean hasNext() {
                if (current == null) {
                    return head != null;
                } else {
                    return current.getNext() != null;
                }
            }

            @Override
            public T next() {
                if (current == null) {
                    current = head;
                } else {
                    current = current.getNext();
                }

                if (current == null) {
                    throw new NoSuchElementException();
                }

                return current.getContent();
            }

            @Override
            public void remove() {
               // TODO Auto-generated method stub
               
            }
        };
    }
    /** 
     * saves actual List into Excel-file.
     * @param filename 
     * @return true if new excel-file was saved, else false
     */
    public boolean saveExcel(String filename){
       
       String excelFileName = filename;
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
       Date date = new Date();
       String sheetName = dateFormat.format(date);
       
       File file = new File(excelFileName);
       HSSFWorkbook wb = null;
       try{
          InputStream input = new FileInputStream(file);
          try {
             //if file exists, load thisfile into Workbook
            wb = new HSSFWorkbook(input);
         } catch (IOException e) {
            // else create new empty Workbook
            wb = new HSSFWorkbook();
         }
       }
       catch(FileNotFoundException fnfEx){
          wb = new HSSFWorkbook();
       }
       catch(SecurityException  securEx){
          wb = new HSSFWorkbook();
       }
       HSSFSheet sheet;
       try{
           sheet = wb.createSheet(sheetName) ;
       }
       catch(IllegalArgumentException iaEx){
          Random rand = new Random();
          sheet = wb.createSheet(sheetName+"."+rand.nextInt());
       }

       CellStyle headerStyle = wb.createCellStyle();
       Font headerFont = wb.createFont();
       headerFont.setBold(true);
       headerStyle.setFont(headerFont);
       headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
       headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
       
       HSSFRow headerRow = sheet.createRow(0);
       //die zeile funktioniert nich wie gewollt setRowStyle überschreibt nicht CellStyle
       headerRow.setRowStyle(headerStyle);
       
       HSSFCell indexHeader = headerRow.createCell(0);
       indexHeader.setCellValue("Index");
       indexHeader.setCellStyle(headerStyle);
       
       HSSFCell contentHeader = headerRow.createCell(1);
       contentHeader.setCellValue("Content");
       contentHeader.setCellStyle(headerStyle);
       
       CellStyle cellStyle1 = wb.createCellStyle();
       cellStyle1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
       cellStyle1.setFillPattern(CellStyle.SOLID_FOREGROUND);
       
       Iterator<T> iter = this.iterator();
       for(int r = 0; iter.hasNext(); r++) {
          HSSFRow row = sheet.createRow(r+1);
          HSSFCell index = row.createCell(0);
          index.setCellValue(r);
          HSSFCell cont = row.createCell(1);
          cont.setCellValue(iter.next().toString());
          if(r%2==0){
             //row.setRowStyle(cellStyle1);
             index.setCellStyle(cellStyle1);
             cont.setCellStyle(cellStyle1);
          }
       }
       boolean done = false; //successful saved?
       FileOutputStream fileOut = null;
       try{
          fileOut = new FileOutputStream(excelFileName);
          wb.write(fileOut);
          done = true;
       }
       catch(FileNotFoundException fnfEx) {
       // TODO: handle exception
       }
       catch (SecurityException  securEx) {
       // TODO: handle exception
      }
       catch (IOException ioEx) {
       // TODO: handle exception
       }
       finally{
          try{
             if(null!=fileOut){
                wb.close();
                fileOut.close();
             }
          }
          catch(IOException ioEx){
          // TODO: handle exception
          }
       }
       return done;
    }
    /**
     * 
     * @param fileName
     * @param sheetName
     * @return
     */
    public LinkedList<String> readExcel(String fileName, String sheetName){
       LinkedList<String> list = new  LinkedList<String>();
       String excelFileName = fileName;
       File file = new File(excelFileName);
       HSSFWorkbook wb = null;
       InputStream input = null;
       try{
          input = new FileInputStream(file);
          try {
             wb = new HSSFWorkbook(input);
             HSSFSheet sheet = wb.getSheet(sheetName);
             if(null!=sheet){
                Iterator<Row> rows = sheet.rowIterator();
                while (rows.hasNext()){
                   Row row = rows.next();
                   if(row.getRowNum()==0){
                      continue;
                   }
                   String s = row.getCell(1).getStringCellValue();
                   list.add(s);
                }
             }
            return list; 
             
         } catch (IOException e) {
            // TODO: handle exception
         }
       }
       catch(FileNotFoundException fnfEx){
          // TODO: handle exception
       }
       catch(SecurityException  securEx){
          // TODO: handle exception
       }
       finally{
          try{
             if(null!=input){
                input.close();
             }
             if(null!=wb){
               wb.close(); 
             }
          }
          catch(IOException e){
          // TODO: handle exception
          }
       }
       return null;
    }
}
