import java.security.PublicKey;
import java.util.ArrayList;

public class HeapImpl {

    static class heap {
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data) {
             
            list.add(data);
            int x = list.size() - 1;
            int par = (x - 1) / 2;
            while (x > 0) {

                if (list.get(par) > list.get(x)) {
                    // swap
                    int temp = list.get(x);
                    list.set(x, list.get(par));
                    list.set(par, temp);
                    x = par;
                    par = (x - 1) / 2;
                } else {
                    break;
                }

            }
        } 
         

        public int peek() {
            return list.get(0);
        }

        public void heapify(int i) {
            int minIdx = i;
            int left = (2 * i + 1);
            int right = (2 * i + 2);

            if (left < list.size() && list.get(minIdx) > list.get(left)) {
                minIdx = left;
            }
            if (right < list.size() && list.get(minIdx) > list.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = list.get(0);
            // swap first to last
            int temp = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.set(list.size() - 1, temp);

            list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                heapify(0);
            }
            return data;
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    public static void main(String[] args) {
        heap hp = new heap();
        hp.add(23);
        hp.add(2);
        hp.add(21);
        hp.add(27);
        hp.add(30);

        while (!hp.isEmpty()) {
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
