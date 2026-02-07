package CollectionsFramework;
import java.util.*;

public class HashMapCF {
    public static void main(String[] args) {
        /*
         * HashMap:
         * - Part of Java Collections Framework
         * - Implements Map interface
         * - Stores data as key-value pairs
         * - Keys are UNIQUE, values can be duplicate
         * - Does NOT maintain insertion order
         * - Allows ONE null key, multiple null values
         * - Not synchronized (not thread-safe)
         */

        /* =======================
           Creation
           ======================= */

        /*
         * O(1)
         */
        HashMap<Integer, String> map = new HashMap<>();

        /*
         * Initial capacity = 16
         * Load factor = 0.75
         * Resize happens when size > capacity * loadFactor
         */
        HashMap<Integer, String> mapWithCapacity = new HashMap<>(32, 0.75f);


        /* =======================
           Adding / Updating Entries
           ======================= */

        /*
         * put(key, value)
         * - Inserts key-value pair
         * - If key already exists → value is replaced
         * - Average Time Complexity: O(1)
         * - Worst Case: O(n) (hash collision)
         */
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Overwrites value for key = 2
        map.put(2, "TWO");


        /* =======================
           Accessing Values
           ======================= */

        /*
         * get(key)
         * - Returns value mapped to key
         * - Returns null if key not present
         * - Average Time Complexity: O(1)
         */
        String value = map.get(2);

        /*
         * getOrDefault(key, defaultValue)
         * - Avoids null checks
         * - Time Complexity: O(1)
         */
        String val = map.getOrDefault(5, "Not Found");


        /* =======================
           Checking Presence
           ======================= */

        /*
         * containsKey(key)
         * - Checks if key exists
         * - Time Complexity: O(1)
         */
        boolean hasKey = map.containsKey(1);

        /*
         * containsValue(value)
         * - Linear search over values
         * - Time Complexity: O(n)
         */
        boolean hasValue = map.containsValue("Three");


        /* =======================
           Removing Entries
           ======================= */

        /*
         * remove(key)
         * - Removes key-value pair
         * - Time Complexity: O(1)
         */
        map.remove(3);


        /* =======================
           Size
           ======================= */

        /*
         * size()
         * - Returns number of key-value pairs
         * - Time Complexity: O(1)
         */
        int size = map.size();


        /* =======================
           Iterating HashMap (VERY IMPORTANT)
           ======================= */

        /*
         * entrySet()
         * - Best & most efficient way to iterate
         * - Time Complexity: O(n)
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /*
         * keySet()
         * - Iterates over keys
         * - Time Complexity: O(n)
         */
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        /*
         * values()
         * - Iterates over values
         * - Time Complexity: O(n)
         */
        for (String v : map.values()) {
            System.out.println(v);
        }


        /* =======================
           Common Interview Pattern
           ======================= */

        /*
         * Frequency Count using HashMap
         * - Time Complexity: O(n)
         */
        int[] arr = {1, 2, 1, 3, 2, 1};
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println(freq);
    }
}
