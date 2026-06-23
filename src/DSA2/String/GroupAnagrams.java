package DSA2.String;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) return new ArrayList<>();
//
//        List<List<String>> anagramList = new ArrayList<>();
//        List<String> firstlist = new ArrayList<>();
//        firstlist.add(strs[0]);
//        anagramList.add(firstlist);
//
//        for (int i = 1; i < strs.length; i++) {
//            String s1 = strs[i];
//            boolean anagramFound = false;
//            for (int j = 0; j < anagramList.size(); j++) {
//                if (isAnagram(s1, anagramList.get(j).get(0))) {
//                    anagramList.get(j).add(s1);
//                    anagramFound = true;
//                }
//            }
//            if (!anagramFound) {
//                List<String> temp = new ArrayList<>();
//                temp.add(s1);
//                anagramList.add(temp);
//
//            }
//        }
//
//        return anagramList;
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            } else {
                map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());

//        List<List<String>> res = new ArrayList<>();
//        for (String key : map.keySet()) {
//            List<String> list = map.get(key);
//            res.add(list);
//        }
//        return res;
    }

    public static boolean isAnagram(String s1, String s2) {
        int[] alphabets = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabets[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            alphabets[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
