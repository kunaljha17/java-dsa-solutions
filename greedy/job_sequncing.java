import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

  class job {
    int index;
    int deadline;
    int profit;
    public job(int index, int deadline, int profit) {
        this.index = index;
        this.deadline = deadline;
        this.profit = profit;
    }

}

public class job_sequncing {
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        
        ArrayList<job> jobs = new ArrayList<>();

        for(int i =0; i<jobInfo.length;i++){
            jobs.add(new job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        Collections.sort(jobs,(obj1 ,obj2) -> obj2.profit-obj1.profit);
        //descending order of profit

        ArrayList<Integer> seq = new ArrayList<>();   
        int time =0;
        for(int i =0;i<jobs.size();i++){
            job curr =jobs.get(i); 
            if (curr.deadline>time) {
                time++;
                seq.add(curr.index);
            }
        }
        
        System.out.println("Max jobs = " + seq.size());
        System.out.println(seq);
       
        
    }
}
