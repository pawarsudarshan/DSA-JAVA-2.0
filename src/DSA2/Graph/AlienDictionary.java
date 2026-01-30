package DSA2.Graph;
import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(words));
    }

    public static String findOrder(String[] words) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] seen = new boolean[26];

        // Mark seen characters
        for (String w : words) {
            for (char c : w.toCharArray()) {
                seen[c - 'a'] = true;
            }
        }

        // Initialize adjacency lists
        for (int i = 0; i < 26; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build graph using first difference rule + prefix check
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int min = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < min; j++) {
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if (c1 != c2) {
                    int u = c1 - 'a', v = c2 - 'a';
                    graph.get(u).add(v);

                    indegree[v]++;
                    found = true;

                    break;
                }
            }

            // Invalid if s1 is a strict prefix of s2? No — that’s valid.
            // Invalid if s2 is a prefix of s1 (s1 longer) and no differing char found.
            if (!found && s1.length() > s2.length()) {
                return ""; // invalid ordering due to prefix rule
            }
        }

        // Kahn's BFS
        Queue<Integer> q = new LinkedList<>();
        int seenCount = 0;
        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                seenCount++;
                if (indegree[i] == 0) q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append((char)(node + 'a'));

            for (int adj : graph.get(node)) {
                if (--indegree[adj] == 0) q.offer(adj);
            }
        }

        // IMPORTANT: detect cycle/incompleteness
        if (sb.length() != seenCount) {
            return ""; // cycle detected or constraints inconsistent
        }

        return sb.toString();
    }

}
