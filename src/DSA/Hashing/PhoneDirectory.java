package Hashing;
import java.util.*;

public class PhoneDirectory {
    public static void main(String[] args) {
        String[] contact = {"geeikistest", "geeksforgeeks",
                "geeksfortest"};
        String s = "geeips";
        int n = contact.length;
        ArrayList<ArrayList<String>> list = displayContacts(n,contact,s);
        System.out.println(list);
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s)
    {
        // This question can also be efficiently solved using Trie

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        TreeMap<String,Integer> m = new TreeMap<>();

        for(int i=0;i<n;i++){
            if(m.containsKey(contact[i])){
                m.put(contact[i],m.get(contact[i])+1);
            } else {
                m.put(contact[i],1);
            }
        }

        for(int i=0;i<s.length();i++){
            ArrayList<String> templist = new ArrayList<>();
            String str = s.substring(0,i+1);
            for(Map.Entry<String,Integer> pair : m.entrySet()){
                String temp = pair.getKey();
                    if (temp.length() >= i+1) {
                        if (temp.substring(0, i + 1).compareTo(str) == 0) {
                            templist.add(pair.getKey());
                        }
                    }
            }
            if(templist.size()==0)
                templist.add("0");
            list.add(templist);
        }

        return list;
    }
}
