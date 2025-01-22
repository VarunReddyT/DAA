package Greedy;
import java.util.*;

class Pair{
    int vertex;
    int distance;
    public Pair(int vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }
}

public class single_source_shortest_path{

    public static void dijkstra(int[][] graph, int source, int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.distance, p2.distance);
            }
        });
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] distance = new int[v];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;

        pq.add(new Pair(source,0));

        boolean[] visited = new boolean[v];

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.vertex;

            if(visited[u] == true){
                continue;
            }

            visited[u] = true;

            for(int i = 0;i<v;i++){
                if(graph[u][i] != 0 && !visited[i]){
                    int newDist = graph[u][i] + distance[u];
                    if(newDist<distance[i]){
                        distance[i] = newDist;
                        pq.add(new Pair(i, newDist));
                    }
                }
            }
            display(distance, v);
        }

    }

    public static void display(int[] distance,int v){
        System.out.println("Vertex           Distance from Source");
        for(int i = 0;i<v;i++){
            System.out.println(i + "                " + distance[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        
        int[][] graph = new int[v][v];
        
        for(int i = 0;i<v;i++){
            for(int j = 0;j<v;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        int source = sc.nextInt();

        dijkstra(graph,source,v);
        
        sc.close();
    }
}