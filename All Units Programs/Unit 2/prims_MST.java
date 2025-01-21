import java.util.*;

class Pair{
    int vertex;
    int weight;
    int parent;
    Pair(int vertex, int weight, int parent){
        this.vertex = vertex;
        this.weight = weight;
        this.parent = parent;
    }
}

public class prims_MST{

    public static void getMST(int[][] graph, int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[n];
        pq.add(new Pair(0, 0,-1));
        int[] parent = new int[n];
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        parent[0] = -1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();

            if(visited[p.vertex]) continue;

            visited[p.vertex] = true;
            for(int i=0; i<n; i++){
                if(graph[p.vertex][i] != 0 && !visited[i] && graph[p.vertex][i] < weight[i]){
                    weight[i] = graph[p.vertex][i];
                    parent[i] = p.vertex;
                    pq.add(new Pair(i, weight[i], p.vertex));
                }
            }
        }
        System.out.println("Edge\tWeight");
        for(int i=1; i<n; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        
        getMST(graph, n);

        sc.close();

    }
}

