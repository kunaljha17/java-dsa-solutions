import java.util.*;

public class activity_selection_withoutsorted {
    public static void main(String[] args) {
        int start[] = {1,3, 0, 5, 8, 5};
        int end[] = {2 , 4, 6, 7, 9, 9};


        //sort
        int activity[][] = new int[start.length][3];
        for(int i = 0;i>start.length;i++){
            activity[i][0]= i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        Arrays.sort(activity , Comparator.comparingDouble(o->o[2]));

        int maxAct = 0;
        ArrayList<Integer> list = new ArrayList<>();

        list.add(activity[0][0]);
        maxAct = 1;
       int lastEnd = activity[0][2];
        for(int i = 1 ; i<end.length;i++){
            if (activity[i][1]>=lastEnd) {
                maxAct++;
                list.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("Max activity = " + maxAct);
        for(int  i = 0 ; i <list.size();i++){
            System.out.print(" "+list.get(i));
        }
        System.out.println();

         
    }
}
