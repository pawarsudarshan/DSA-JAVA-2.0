package RandomDSAQuestions2;

import java.util.*;

public class HashingJava2 {
    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<>();

        // Insertion
        m.put("India", 120);
        m.put("China", 150);
        m.put("US", 30);

        System.out.println(m);

        m.put("China", 180); // reinsertion will update its value

        System.out.println(m);

        // Search or Lookup  .containsKey()
        if(m.containsKey("China"))
            System.out.println("Key is present in the map");
        else System.out.println("Key is not present in the map");

        // Get value corresponding to that key .get()
        System.out.println(m.get("China"));
        System.out.println(m.get("Chile")); // gives null

        // enhanced for loop to get key and value
        for(Map.Entry<String,Integer> val: m.entrySet()){
            System.out.println(val.getKey()+ " "+ val.getValue());
        }

        // Alternate way
        Set<String> keys = m.keySet();

        for(String key:keys){
            System.out.print(key+ " ");
            System.out.println(m.get(key));
        }

        TreeMap<Integer,String> myMap = new TreeMap<>();
        myMap.put(113,"Sudarshan");
        myMap.put(109, "Vishal");
        myMap.put(72,"Sudipta");

        System.out.println(myMap);
    }
}