import java.util.*;
public class Priority_queue {

    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(int rank, String name){
            this.rank = rank;
            this.name = name; 
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>( );//ascending order
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());// descending order

        // pq.add(12);
        // pq.add(20);
        // pq.add(1);
        // pq.add(3);
        // pq.add(78);


        pq.add(new Student(12, "kunal"));//O(logn)
        pq.add(new Student(1, "kartik"));
        pq.add(new Student(23, "Mummy"));
        pq.add(new Student(2, "papa"));
        pq.add(new Student(17, "dadi"));
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+"-> "+pq.peek().rank);//O(1)
            pq.remove();
        }
    }
}
