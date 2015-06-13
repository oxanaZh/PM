package src.b07;

import java.util.Iterator;

public class Main {

   public static void main(String[] args) {
      LinkedList<String> list = new LinkedList<>();
      list.add("first");
      list.add("second");
      list.add("third");
      list.add("any string");

      Iterator iter = list.iterator();
      while(iter.hasNext()){
         System.out.println(iter.next().toString());
      }
      if(list.saveExcel()){
         System.out.println("gespeichert");
      }
      else{
         System.out.println("speichern fehlgeschlgen.");
      }
      
   }

}
