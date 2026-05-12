import java.util.*;

public class hashmap_p1 {
    public static void main(String[] args){
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("kj", 17);
        hm.put("Niku", 07);
        hm.put("mummy", 10);
        hm.put("papa", 01);

        Set<String> keys = hm.keySet();

        System.out.println(hm.get("Niku"));
        System.out.println(hm.containsKey("dadi"));

        for(String key : keys){
            System.out.println(key);
        }
    }
}