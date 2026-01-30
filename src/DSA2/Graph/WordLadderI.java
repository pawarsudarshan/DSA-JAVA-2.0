package DSA2.Graph;
import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(wordLadderLength(startWord,targetWord,wordList));
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair3> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        Set<String>  visited = new HashSet<>();

        wordSet.addAll(Arrays.asList(wordList));
        q.offer(new Pair3(startWord,1));
        visited.add(startWord);

        if(!wordSet.contains(targetWord)) return 0;

        while(!q.isEmpty()){
            Pair3 p = q.poll();
            int step = p.step;

            for(int i=0;i<p.word.length();i++){
                StringBuilder sb = new  StringBuilder(p.word);
                for(int j=0;j<26;j++){
                    sb.replace(i,i+1, String.valueOf((char)(j+'a')));
                    if(sb.toString().equals(targetWord)){
                        return step+1;
                    }
                    if(!visited.contains(sb.toString()) && wordSet.contains(sb.toString())){
                        q.offer(new Pair3(sb.toString(),step+1));
                        visited.add(sb.toString());
                    }
                }
            }
        }

        return 0;
    }
}
class Pair3{
    String word;
    int step;
    public Pair3(String word, int step){
        this.word = word;
        this.step = step;
    }
}