package DSA2.Graph.DisjointSet;
import java.util.*;

public class MSTUsingDSU {
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        DSU2 d = new DSU2(V);
        PriorityQueue<Tuple5> pq = new PriorityQueue<>((a,b)->{
            return a.wt - b.wt;
        });

        for(int i=0;i<edges.length;i++){
            pq.add(new Tuple5(edges[i][2],edges[i][0],edges[i][1]));
        }

        int mstSum = 0;

        while(!pq.isEmpty()){
            Tuple5 t = pq.poll();
            int u = t.u;
            int v = t.v;
            int wt = t.wt;


            if(d.findParent(u)==d.findParent(v)){

            }else{
                d.add(u,v);
                mstSum += wt;
            }
        }
        return mstSum;
    }
}
class DSU2{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    DSU2(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(1);
        }
    }

    public int findParent(int node){
        if(node==parent.get(node)) return node;

        int root = findParent(parent.get(node));
        parent.set(node,root);
        return root;
    }


    public void add(int u, int v){
        int p1 = findParent(u);
        int p2 = findParent(v);

        if(p1==p2) return;

        if(rank.get(p1) > rank.get(p2)){
            parent.set(p2,p1);
        }
        else if(rank.get(p2) > rank.get(p1)){
            parent.set(p1,p2);
        }
        else{
            parent.set(p1,p2);
            rank.set(p2,rank.get(p2)+1);
        }
    }

}

class Tuple5{
    int wt, u, v;
    Tuple5(int wt, int u, int v){
        this.wt = wt;
        this.u = u;
        this.v = v;
    }
}

