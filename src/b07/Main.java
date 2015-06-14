package src.b07;

import java.util.Iterator;

public class Main {

   public static void main(String[] args) {
      LinkedList<String> list = new LinkedList<>();
      list.add("first");
      list.add("second");
      list.add("third");
      list.add("any string");
      list.add("something");

      Iterator<String> iter = list.iterator();
      while(iter.hasNext()){
         System.out.println(iter.next().toString());
      }
      if(list.saveExcel()){
         System.out.println("gespeichert");
      }
      else{
         System.out.println("speichern fehlgeschlgen.");
      }
      
      LinkedList<String> list2= list.readExcel("LinkedListExcel.xls", "2015-06-14 08.37.46");
      if(null!=list2){
         Iterator<String> iter2 = list2.iterator();
         while(iter2.hasNext()){
            System.out.println(iter2.next().toString());
         }
      }
      list2.saveExcel();
      
   }

}
