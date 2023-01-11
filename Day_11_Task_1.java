package Manipal_practise;
import java.util.ArrayList;
import java.util.Iterator;

class demo {
    String name1 ;
    String place ;


    public demo(String name1, String place) {
        this.name1 = name1;
        this.place = place;
    }
}

public class Day_11_Task_1 {
    public static void main(String[] args) {
        ArrayList <demo> list = new ArrayList<>();
        var dem = new demo("DV", "jbp");
        var dem1 = new demo("pv" , "bp");
        var dem2 = new demo("cv" , "pl");
        list.add(dem);
        list.add(dem1);
        list.add(dem2);

        for (demo d: list) {
            System.out.println( d.name1 + d.place );
        }

        System.out.println();

        Iterator it = list.iterator();
        while(it.hasNext()){
            demo obj = (demo) it.next();
            System.out.println(obj.name1);
            System.out.println(obj.place);
        }
    }
}
