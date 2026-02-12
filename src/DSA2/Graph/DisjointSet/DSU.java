package DSA2.Graph.DisjointSet;
import java.util.*;

public class DSU {
    public static void main(String[] args) {
        DisjointSet ds1 = new DisjointSet(6);
        ds1.unionBySize(1,2);
        ds1.unionBySize(2,3);
        ds1.unionBySize(4,5);
        ds1.unionBySize(5,6);

        if(ds1.findParent(3) == ds1.findParent(4)){
            System.out.println("In same union");
        }

        else{
            System.out.println("Not in same union");
        }

        ds1.unionBySize(2,5);

        if(ds1.findParent(3) == ds1.findParent(4)){
            System.out.println("In same union");
        }

        else{
            System.out.println("Not in same union");
        }
    }
}

/* Union by Rank
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0); // rank is zero initially
            parent.add(i); // initial parent is themselves
        }
    }

    public int findParent(int node){
        if(node==parent.get(node)){
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int p1 = findParent(u);
        int p2 = findParent(v);

        if(p1==p2) return; // in the same union

        if(rank.get(p1) < rank.get(p2)){
            parent.set(p1,p2);
        }
        else if(rank.get(p1) > rank.get(p2)){
            parent.set(p2,p1);
        }
        else{
            parent.set(p1,p2);
            int newRank = rank.get(p2) + 1;
            rank.set(p2,newRank);
        }
    }

}
*/

/* Union by Size */
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1); // size is 1 initially
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU == rootV) {
            return;
        }

        if (size.get(rootU) < size.get(rootV)) {
            parent.set(rootU, rootV);
        } else {
            parent.set(rootV, rootU);
            size.set(rootU, size.get(rootU) + size.get(rootV));
        }
    }
}
