package DSA2.Graph;
import java.util.*;

// print all shortest length transformation sequences

public class WordLadderII {
    public static void main(String[] args) {
        String startWord = "der";
        String targetWord = "dfs";
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        System.out.println(findSequences(startWord,targetWord,wordList));
    }

    // For GFG submission
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        Queue<ArrayList<String>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        ArrayList<ArrayList<String>> res = new ArrayList<>();

        q.offer(new ArrayList<>(Arrays.asList(startWord)));
        visited.add(startWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int s = 0; s < size; s++) {
                ArrayList<String> cur = q.poll();
                String word = cur.get(cur.size() - 1);

                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);

                        if (wordSet.contains(next) && !visited.contains(next)) {
                            ArrayList<String> temp = new ArrayList<>(cur);
                            temp.add(next);

                            if (next.equals(targetWord)) {
                                found = true;
                                res.add(temp);
                            } else {
                                q.offer(temp);
                            }
                            levelVisited.add(next);
                        }
                    }
                }
            }
            visited.addAll(levelVisited);
        }
        return res;
    }

    // For LeetCode submission
    public static List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        List<List<String>> res = new ArrayList<>();

        q.offer(new ArrayList<>(Arrays.asList(startWord)));
        visited.add(startWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int s = 0; s < size; s++) {
                List<String> cur = q.poll();
                String word = cur.get(cur.size() - 1);

                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);

                        if (wordSet.contains(next) && !visited.contains(next)) {
                            List<String> temp = new ArrayList<>(cur);
                            temp.add(next);

                            if (next.equals(targetWord)) {
                                found = true;
                                res.add(temp);
                            } else {
                                q.offer(temp);
                            }
                            levelVisited.add(next);
                        }
                    }
                }
            }
            visited.addAll(levelVisited);
        }
        return res;
    }
}