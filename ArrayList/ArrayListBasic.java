import java.util.*;

public class ArrayListBasic {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(7);
        System.out.println(list);
        // list.add(value) ,
        // list.remove(index),list.get(index),list.set(index,value),list.contains(value),list.add(index,value);
        // list.size(),
        // Collections.sort(list);
        // Collections.sort(list , Collections.reverseOrder());
        // System.out.println(list);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();

        list2.add(2);
        list2.add(5);
        list2.add(10);
        list3.add(12);
        list3.add(10);
        list3.add(8);
        list4.add(1);
        list4.add(3);
        list4.add(120);
        mainList.add(list2);
        mainList.add(list3);
        mainList.add(list4);
        // System.out.println(mainList);
        //Here we see 2D Arraylist making ...

        //All array problem solve by arraylist also .
        //1.Dynamic size
        //Not store primitive data type
    }
}