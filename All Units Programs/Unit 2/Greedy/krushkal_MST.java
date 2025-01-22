package Greedy;
import java.util.*;
class Edge{
    int src, dest, weight;
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
class Subset{
    int parent, rank;
    Subset(int parent, int rank){
        this.parent = parent;
        this.rank = rank;
    }
}
public class krushkal_MST{
    public static int findMinimumCost(int v, Edge[] edges){
        Arrays.sort(edges, (a, b) -> a.weight - b.weight);
        Subset[] subsets = new Subset[v];
        for(int i=0; i<v; i++){
            subsets[i] = new Subset(i, 0);
        }
        int cost = 0;
        int count = 0;
        for(Edge edge: edges){
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if(x != y){
                union(subsets, x, y);
                cost += edge.weight;
                count++;
            }
            if(count == v-1){
                break;
            }
        }
        return cost;
    }
    public static int find(Subset[] subsets, int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    public static void union(Subset[] subsets, int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if(subsets[xroot].rank < subsets[yroot].rank){
            subsets[xroot].parent = yroot;
        }
        else if(subsets[xroot].rank > subsets[yroot].rank){
            subsets[yroot].parent = xroot;
        }
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for(int i=0; i<e; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges[i] = new Edge(src, dest, weight);
        }
        System.out.println(findMinimumCost(v, edges));
        
        sc.close();
    }
}